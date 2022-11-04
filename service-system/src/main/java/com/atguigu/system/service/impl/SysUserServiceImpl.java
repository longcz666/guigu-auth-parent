package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.model.vo.RouterVo;
import com.atguigu.model.vo.SysUserQueryVo;
import com.atguigu.system.mapper.SysUserMapper;
import com.atguigu.system.service.SysMenuService;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
* @author 25986
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2022-11-01 13:49:53
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public IPage<SysUser> getPageUser(Long page, Long limit, SysUserQueryVo sysUserQueryVo) {
        Page<SysUser> sysUserPage = new Page<>(page, limit);
        return sysUserMapper.selectPageUser(sysUserPage, sysUserQueryVo);
    }

    @Override
    public void updateStatus(Long id, Long status) {
        sysUserMapper.updateStatus(id, status);
    }

    @Override
    public SysUser getUserByName(LoginVo loginVo) {

        //根据用户名查询数据库
        LambdaQueryWrapper<SysUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SysUser::getUsername,loginVo.getUsername());
        return sysUserMapper.selectOne(lqw);
    }

    @Override
    public HashMap<String, Object> getUserInfo(String username) {
        //查询用户基本信息
        LambdaQueryWrapper<SysUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SysUser::getUsername,username);
        SysUser sysUser = sysUserMapper.selectOne(lqw);

        //根据用户id获取菜单权限值
        List<RouterVo> routerVoList = sysMenuService.findUserMenuList(sysUser.getId());
        //根据用户id获取用户按钮权限
        List<String> permsList = sysMenuService.findUserPermsList(sysUser.getId());

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", username);
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("roles","admin");
        //菜单权限
        map.put("routers",routerVoList);
        //按钮权限
        map.put("buttons",permsList);
        return map;
    }

}




