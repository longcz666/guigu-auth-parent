package com.atguigu.system.mapper;

import com.atguigu.model.system.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25986
* @description 针对表【sys_dept(组织机构)】的数据库操作Mapper
* @createDate 2022-11-09 23:50:26
* @Entity com.atguigu.system.entity.SysDept
*/
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {

}




