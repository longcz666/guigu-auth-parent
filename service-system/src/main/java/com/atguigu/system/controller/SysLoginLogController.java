package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.atguigu.system.service.LoginLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: longcz
 * @Date: 2022/11/7 - 11 - 07 - 18:15
 * @Description: com.atguigu.system.controller
 * @version: 1.0
 */
@Api(value = "SysLoginLog管理", tags = "SysLoginLog管理")
@RestController
@RequestMapping(value="/admin/system/sysLoginLog")
@SuppressWarnings({"rawtypes"})
@RequiredArgsConstructor
public class SysLoginLogController {

    private final LoginLogService loginLogService;

     /**
      * @Param:
      * @Return:
      * @Throws:
      * @Description:条件分页查询登录日志
      */
    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(@PathVariable Long page, @PathVariable Long limit,
                        SysLoginLogQueryVo sysLoginLogQueryVo){
        IPage<SysLoginLog> pageModel = loginLogService.getPage(page, limit, sysLoginLogQueryVo);
        return Result.ok(pageModel);
    }
}
