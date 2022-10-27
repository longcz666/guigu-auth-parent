package com.atguigu.system.controller;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: longcz
 * @Date: 2022/10/27 - 10 - 27 - 16:02
 * @Description: com.atguigu.system.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/system/sysRol")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;



    /**
     * @Description: 查询全部
     * @Param:
     * @Throws:
     * @Return:
     */
    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        List<SysRole> roleList = sysRoleService.list();
        return roleList;
    }

    /**
     * @Description: 按id删除
     * @Param: id
     * @Throws:
     * @Return:
     */
    @DeleteMapping("/remove/{id}")
    public boolean removeById(@PathVariable Long id){
        return sysRoleService.removeById(id);
    }

    /**
     * @Description: 增加
     * @Param:
     * @Throws:
     * @Return:
     */
    @PostMapping("/save")
    public boolean save(@RequestBody SysRole sysRole){
        return sysRoleService.save(sysRole);
    }

}
