package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.system.SysUserRole;
import com.atguigu.model.vo.AssginRoleVo;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.system.mapper.SysUserRoleMapper;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public IPage<SysRole> getPageRole(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo) {

        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(SysRole::getRoleName, sysRoleQueryVo.getRoleName())
                .orderByAsc(SysRole::getId);
        if (sysRoleQueryVo.getRoleName() == null) {
            return sysRoleMapper.selectPage(sysRolePage, null);
        } else {
            return sysRoleMapper.selectPage(sysRolePage, wrapper);
        }
    }

    @Override
    public Map<String, Object> getRoleByUserId(String userId) {
        //获取全部角色
        List<SysRole> roleList = sysRoleMapper.selectList(null);
        //根据用户id查询，已经分配的角色
        LambdaQueryWrapper<SysUserRole> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SysUserRole::getUserId, userId);
        List<SysUserRole> userRoleList = sysUserRoleMapper.selectList(lqw);
        //从userRoleList获取所有角色id
        ArrayList<String> roleIds = new ArrayList<>();
        for (SysUserRole roles :
                userRoleList) {
            String roleId = roles.getRoleId();
            roleIds.add(roleId);
        }
        //创建返回的Map
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("allRoles", roleList);
        returnMap.put("userRoleIds", roleIds);
        return returnMap;
    }

    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        //根据用户id删除原来分配的角色
        /*QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",assginRoleVo.getUserId());
        sysUserRoleMapper.delete(queryWrapper);*/

        sysUserRoleMapper.myDelete(assginRoleVo.getUserId());

        //获取所有的角色id
        List<String> roleIdList = assginRoleVo.getRoleIdList();
        for (String roleId : roleIdList) {
            if (roleId != null) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(assginRoleVo.getUserId());
                sysUserRole.setRoleId(roleId);
                //保存
                sysUserRoleMapper.insert(sysUserRole);
            }
        }
    }
}
