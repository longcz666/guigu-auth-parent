package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: longcz
 * @Date: 2022/10/27 - 10 - 27 - 15:47
 * @Description: com.atguigu.system.service.impl
 * @Version: 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public IPage<SysRole> getPageRole(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo) {

        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(SysRole::getRoleName,sysRoleQueryVo.getRoleName())
                .orderByAsc(SysRole::getId);
        if (sysRoleQueryVo.getRoleName() == null){
            return sysRoleMapper.selectPage(sysRolePage,null);
        }else{
            return sysRoleMapper.selectPage(sysRolePage, wrapper);
        }
    }
}
