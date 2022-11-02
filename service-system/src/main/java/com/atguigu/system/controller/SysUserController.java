package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: longcz
 * @Date: 2022/11/1 - 11 - 01 - 13:51
 * @Description: com.atguigu.system.controller
 * @Version: 1.0
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("更改用户状态")
    @PutMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id,
                               @PathVariable Long status){
        sysUserService.updateStatus(id,status);
        return Result.ok();
    }

    @ApiOperation("条件分页查询")
    @GetMapping("/{page}/{limit}")
    public Result getPageUser(@PathVariable Long page,
                              @PathVariable Long limit,
                              SysUserQueryVo sysUserQueryVo) {
        IPage<SysUser> model = sysUserService.getPageUser(page, limit, sysUserQueryVo);
        return Result.ok(model);
    }

    @ApiOperation("根据id查询")
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Long id) {
        SysUser byId = sysUserService.getById(id);
        return Result.ok(byId);
    }

    @ApiOperation("添加用户")
    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody SysUser sysUser) {
        boolean b = sysUserService.save(sysUser);
        if (b) {
            return Result.ok().message("添加成功");
        } else {
            return Result.fail().message("该用户已存在");
        }
    }

    @ApiOperation("修改用户")
    @PutMapping("/updateById")
    public Result updateById(@RequestBody SysUser sysUser) {
        boolean b = sysUserService.updateById(sysUser);
        if (b) {
            return Result.ok().message("修改成功");
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("按id删除")
    @DeleteMapping("/removeById/{id}")
    public Result removeById(@PathVariable Long id) {
        boolean b = sysUserService.removeById(id);
        if (b) {
            return Result.ok().message("删除成功");
        } else {
            return Result.fail().message("该用户不存在");
        }
    }


}
