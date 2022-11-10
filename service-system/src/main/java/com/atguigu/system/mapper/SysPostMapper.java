package com.atguigu.system.mapper;

import com.atguigu.model.system.SysPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25986
* @description 针对表【sys_post(岗位信息表)】的数据库操作Mapper
* @createDate 2022-11-09 23:50:13
* @Entity com.atguigu.system.entity.SysPost
*/
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {

    Boolean updateStatusById(Long id, Long status);
}




