package com.atguigu.system.mapper;

import com.atguigu.model.system.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: longcz
 * @Date: 2022/11/1 - 11 - 01 - 19:17
 * @Description: com.atguigu.system.mapper
 * @Version: 1.0
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    int myDelete(@Param("userId") String userId);
}
