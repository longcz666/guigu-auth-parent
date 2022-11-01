package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: longcz
 * @Date: 2022/10/31 - 10 - 31 - 14:43
 * @Description: com.atguigu.system.controller
 * @Version: 1.0
 */
@Api(tags = "登录接口")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    /**
     * @Description: 登录接口 login
     * @Param:
     * @Throws:
     * @Return:
     */
    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Result login(){
        HashMap<String, String> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map);
    }

    /**
     * @Description: info
     * @Param:
     * @Throws:
     * @Return:
     */
    @ApiOperation("首页初始化接口")
    @GetMapping("/info")
    public Result info(){
        HashMap<String, String> map = new HashMap<>();
        map.put("roles","admin");
        map.put("introduction","I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        return Result.ok(map);
    }

    /**
     * 退出
     * @return
     */
    @ApiOperation("退出")
    @PostMapping("/logout")
    public Result logout(){
        return Result.ok();
    }

}
