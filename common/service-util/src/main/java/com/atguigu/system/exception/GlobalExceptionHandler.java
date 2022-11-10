package com.atguigu.system.exception;

import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @Author: longcz
 * @Date: 2022/10/28 - 10 - 28 - 16:39
 * @Description: com.atguigu.system.exception
 * @Version: 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail().message("执行全局异常处理器");
    }

    //特定异常处理器
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.fail().message("执行特定异常处理器");
    }

    //自定义异常处理器
    @ExceptionHandler(MyExceptionHandler.class)
    @ResponseBody
    public Result error(MyExceptionHandler e){
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }

    /**
     * spring security异常
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public Result error(AccessDeniedException e) throws AccessDeniedException {
        e.printStackTrace();
        return Result.fail().code(ResultCodeEnum.PERMISSION.getCode()).message("您的权限不足，请联系管理员！");
    }

}
