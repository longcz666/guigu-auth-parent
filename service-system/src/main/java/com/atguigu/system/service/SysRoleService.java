package com.atguigu.system.service;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author: longcz
 * @Date: 2022/10/27 - 10 - 27 - 15:45
 * @Description: com.atguigu.system.service.impl
 * @Version: 1.0
 */
public interface SysRoleService extends IService<SysRole> {
    IPage<SysRole> getPageRole(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo);
}
