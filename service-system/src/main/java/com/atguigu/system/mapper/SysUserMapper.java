package com.atguigu.system.mapper;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 25986
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2022-11-01 13:49:53
* @Entity com.atguigu.system.entity.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    IPage<SysUser> selectPageUser(Page<SysUser> sysUserPage, @Param("vo") SysUserQueryVo sysUserQueryVo);

    void updateStatus(Long id, Long status);
}




