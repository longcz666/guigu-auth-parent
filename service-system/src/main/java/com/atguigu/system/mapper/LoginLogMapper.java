package com.atguigu.system.mapper;

import com.atguigu.model.system.SysLoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: longcz
 * @Date: 2022/11/7 - 11 - 07 - 16:30
 * @Description:  登录日志表对应的mapper
 * @version: 1.0
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<SysLoginLog> {

}
