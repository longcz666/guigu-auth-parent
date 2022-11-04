package com.atguigu.system.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.atguigu.common.result.Result;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.system.exception.MyExceptionHandler;
import com.atguigu.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Objects;

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

    @Autowired
    private SysUserService sysUserService;

    /**
     * @Description: 登录接口 login
     * @Param:
     * @Throws:
     * @Return:
     */
    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo){
        //根据用户名和密码查询数据库
        SysUser sysUser = sysUserService.getUserByName(loginVo);

        //判断是否存在
        if (Objects.isNull(sysUser)){
            throw new MyExceptionHandler(2001,"用户名不存在，请先注册后登录!");
        }
        //存在比对密码
        String password = DigestUtil.md5Hex(loginVo.getPassword());
        if (!password.equals(sysUser.getPassword())){
            throw new MyExceptionHandler(2001,"用户名或密码错误");
        }
        //判断用户状态是否可用
        if (sysUser.getStatus() == 0){
            throw new MyExceptionHandler(2001,"该用户已被禁用，请联系管理员！");
        }
        //根据用户id和用户名生成token
        String token = JwtHelper.createToken(Long.valueOf(sysUser.getId()), sysUser.getUsername());
        //返回给前端
        HashMap<String, String> map = new HashMap<>();
        map.put("token",token);
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
    public Result info(HttpServletRequest request){
        //获取并解析token，根据解析到的用户id，查询用户信息
        String token = request.getHeader("token");
        String username = JwtHelper.getUsername(token);
        HashMap<String, Object> map = sysUserService.getUserInfo(username);
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
