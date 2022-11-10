package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysOperLog;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.atguigu.system.service.AsyncOperLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: longcz
 * @Date: 2022/11/10 - 11 - 10 - 1:03
 * @Description: com.atguigu.system.controller
 * @version: 1.0
 */
@Api(value = "SysOperLog管理", tags = "SysOperLog管理")
@RestController
@RequestMapping(value = "/admin/system/sysOperLog")
@SuppressWarnings({"unchecked", "rawtypes"})
@RequiredArgsConstructor
public class SysOperLogController {
    private final AsyncOperLogService asyncOperLogService;

    @GetMapping("/{page}/{limit}")
    public Result getPage(@PathVariable Long page,
                          @PathVariable Long limit,
                          SysOperLogQueryVo sysOperLogQueryVo) {
        IPage<SysOperLog> pageModel = asyncOperLogService.getPage(page, limit, sysOperLogQueryVo);
        return Result.ok(pageModel);
    }
}
