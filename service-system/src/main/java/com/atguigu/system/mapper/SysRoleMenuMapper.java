package com.atguigu.system.mapper;

import com.atguigu.model.system.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: longcz
 * @Date: 2022/11/4 - 11 - 04 - 1:19
 * @Description: com.atguigu.system.mapper
 * @Version: 1.0
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    void myDeleteById(@Param("roleId") String roleId);
}
