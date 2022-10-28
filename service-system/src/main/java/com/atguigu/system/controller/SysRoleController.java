package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.exception.MyExceptionHandler;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @Author: longcz
 * @Date: 2022/10/27 - 10 - 27 - 16:02
 * @Description: com.atguigu.system.controller
 * @Version: 1.0
 */

@Api(tags = "角色管理接口")
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
    @ApiOperation("查询全部")
    @GetMapping("/findAll")
    public Result findAll() {
        try {
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyExceptionHandler(2001,"执行了自定义异常处理");
        }
        List<SysRole> roleList = sysRoleService.list();
        return Result.ok(roleList);
    }

    /**
     * @Description: 根据id查询
     * @Param:
     * @Throws:
     * @Return:
     */
    @ApiOperation("根据id查询")
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        if (Objects.isNull(sysRole)){
            return Result.fail().message("该用户不存在");
        }
        return Result.ok(sysRole);
    }

    /**
     * @Description: 条件分页查询
     * @Param:
     * @Throws:
     * @Return:
     */
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findPageRole(@PathVariable Long page,
                               @PathVariable Long limit,
                               SysRoleQueryVo sysRoleQueryVo) {
        Page<SysRole> sysRolePage = new Page<>(page, limit);
        IPage<SysRole> pageModel = sysRoleService.getPageRole(sysRolePage, sysRoleQueryVo);
        return Result.ok(pageModel);
    }


    /**
     * @Description: 按id删除
     * @Param: id
     * @Throws:
     * @Return:
     */
    @ApiOperation("按id删除")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable Long id) {
        boolean b = sysRoleService.removeById(id);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail().message("该用户不存在");
        }
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids) {
        boolean b = sysRoleService.removeByIds(ids);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * @Description: 增加角色
     * @Param:
     * @Throws:
     * @Return:
     */
    @ApiOperation("增加角色")
    @PostMapping("/save")
    public Result save(@RequestBody SysRole sysRole) {
        boolean b = sysRoleService.save(sysRole);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * @Description: 修改角色
     * @Param:
     * @Throws:
     * @Return:
     */
    @ApiOperation("修改角色")
    @PutMapping("/updateById")
    public Result updateById(@RequestBody SysRole sysRole) {
        boolean b = sysRoleService.updateById(sysRole);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }


}
