package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.atguigu.system.mapper.SysUserMapper;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public IPage<SysUser> getPageUser(Long page, Long limit, SysUserQueryVo sysUserQueryVo) {
        Page<SysUser> sysUserPage = new Page<>(page, limit);
        return sysUserMapper.selectPageUser(sysUserPage, sysUserQueryVo);
    }

    @Override
    public void updateStatus(Long id, Long status) {
        sysUserMapper.updateStatus(id, status);
    }

}




