package com.atguigu.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: longcz
 * @Date: 2022/10/28 - 10 - 28 - 16:58
 * @Description: com.atguigu.system.exception
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyExceptionHandler extends RuntimeException{
    private Integer code;
    private String msg;
}
