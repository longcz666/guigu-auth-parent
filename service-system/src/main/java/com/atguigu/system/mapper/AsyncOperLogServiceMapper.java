package com.atguigu.system.mapper;

import com.atguigu.model.system.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: longcz
 * @Date: 2022/11/7 - 11 - 07 - 18:02
 * @Description: 系统操作日志表对应的mapper
 * @version: 1.0
 */
@Mapper
public interface AsyncOperLogServiceMapper extends BaseMapper<SysOperLog> {
}
