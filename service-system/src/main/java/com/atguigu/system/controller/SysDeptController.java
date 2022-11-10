package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysDept;
import com.atguigu.system.service.SysDeptService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: longcz
 * @Date: 2022/11/9 - 11 - 09 - 23:56
 * @Description: 数据模型是一个树
 * @version: 1.0
 */
@Api(tags = "部门管理接口")
@RestController
@RequestMapping("/admin/system/sysDept")
@RequiredArgsConstructor
public class SysDeptController {

    private final SysDeptService sysDeptService;

    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:部门列表树
     */
    @GetMapping("/findNodes")
    public Result findNodes() {
        List<SysDept> deptList = sysDeptService.findNodes();
        return Result.ok(deptList);
    }

    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:根据id查询
     */
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Long id) {
        SysDept sysDept = sysDeptService.getById(id);
        return Result.ok(sysDept);
    }

    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:增加
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysDept sysDept) {
        boolean flag = sysDeptService.save(sysDept);
        if (flag) {
            return Result.ok().message("添加成功");
        } else {
            return Result.fail().message("该用户已存在");
        }
    }

    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:删除
     */
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        boolean b = sysDeptService.removeDeptById(id);
        if (b) {
            return Result.ok().message("删除成功");
        } else {
            return Result.fail().message("网络异常请重试");
        }
    }

    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:修改
     */
    public Result update(@RequestBody SysDept sysDept){
        boolean b = sysDeptService.updateById(sysDept);
        if (b) {
            return Result.ok().message("修改成功");
        }else {
            return Result.fail().message("网络异常请重试");
        }
    }


}
