package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysUser;
import com.atguigu.system.custom.CustomUser;
import com.atguigu.system.service.SysMenuService;
import com.atguigu.system.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: longcz
 * @Date: 2022/11/6 - 11 - 06 - 1:45
 * @Description: 自定义根据用户名查询用户信息，并将用户信息封装为UserDetails对象
 * @Version: 1.0
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final SysUserService sysUserService;


    private final SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户信息
        SysUser sysUser = sysUserService.getUserInfoByUsername(username);
        if (Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        if (sysUser.getStatus() == 0) {
            throw new RuntimeException("该用户已被禁用，请联系管理员！");
        }
        //根据用户名查询用户对应的权限
        List<String> userPermsList = sysMenuService.findUserPermsList(sysUser.getId());
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String permission : userPermsList) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        return new CustomUser(sysUser, authorities);
    }
}
