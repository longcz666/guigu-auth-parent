package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.atguigu.system.service.SysPostService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: longcz
 * @Date: 2022/11/9 - 11 - 09 - 23:57
 * @Description: 返回的数据模式是一个列表
 * @version: 1.0
 */
@Api(tags = "岗位管理接口")
@RestController
@RequestMapping("/admin/system/sysPost")
@RequiredArgsConstructor
public class SysPostController {
    private final SysPostService sysPostService;

    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:条件分页查询
     */
    @GetMapping("/{page}/{limit}")
    public Result getPage(@PathVariable Long page,
                          @PathVariable Long limit,
                          SysPostQueryVo sysPostQueryVo) {
        IPage<SysPost> pageModel = sysPostService.getPage(page, limit, sysPostQueryVo);
        return Result.ok(pageModel);
    }
    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:根据id查询
     */
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Long id){
        SysPost sysPost = sysPostService.getById(id);
        return Result.ok(sysPost);
    }

    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:增加
     */
    @PostMapping ("/save")
    public Result save(@RequestBody SysPost sysPost){
        boolean save = sysPostService.save(sysPost);
        if (save) {
            return Result.ok().message("添加成功");
        }else {
            return Result.fail().message("该用户已存在");
        }
    }
    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:根据id删除
     */
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id){
        boolean b = sysPostService.removeById(id);
        if (b) {
            return Result.ok().message("删除成功");
        }else {
            return Result.fail().message("网络异常请重试");
        }
    }
    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody SysPost sysPost){
        boolean b = sysPostService.updateById(sysPost);
        if (b) {
            return Result.ok().message("修改成功");
        }else {
            return Result.fail().message("网络异常请重试");
        }
    }
    /**
     * @Param:
     * @Return:
     * @Throws:
     * @Description:状态修改 1可以 0禁用
     */
    @PutMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id,@PathVariable Long status){
        Boolean flag = sysPostService.updateStatusById(id,status);
        if (flag) {
            return Result.ok().message("修改成功");
        }else {
            return Result.fail().message("网络异常请重试");
        }
    }

}
