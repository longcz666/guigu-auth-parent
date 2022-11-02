package com.atguigu.system.service;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 25986
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2022-11-01 13:49:53
*/
public interface SysUserService extends IService<SysUser> {

    IPage<SysUser> getPageUser(Long page, Long limit, SysUserQueryVo sysUserQueryVo);

    void updateStatus(Long id, Long status);
}
