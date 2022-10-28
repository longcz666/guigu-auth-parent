package com.atguigu.system.mapper;

import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: longcz
 * @Date: 2022/10/27 - 10 - 27 - 14:51
 * @Description: com.atguigu.system.mapper
 * @Version: 1.0
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> selectAll();


}
