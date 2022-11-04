package com.atguigu.system.mapper;

import com.atguigu.model.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 25986
* @description 针对表【sys_menu(菜单表)】的数据库操作Mapper
* @createDate 2022-11-02 22:24:06
* @Entity com.atguigu.system.entity.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<String> selectRoleByMenuId(@Param("roleId") String roleId);

    List<SysMenu> findMenuListByUserId(@Param("userId") String userId);
}




