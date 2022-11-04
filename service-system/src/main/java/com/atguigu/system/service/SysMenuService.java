package com.atguigu.system.service;

import com.atguigu.model.system.SysMenu;
import com.atguigu.model.vo.AssginMenuVo;
import com.atguigu.model.vo.RouterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 25986
* @description 针对表【sys_menu(菜单表)】的数据库操作Service
* @createDate 2022-11-02 22:24:06
*/
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> findNodes();

    void removeMenuById(String id);

    List<SysMenu> findMenuByRoleId(String roleId);

    void doAssign(AssginMenuVo assginMenuVo);

    List<RouterVo> findUserMenuList(String id);

    List<String> findUserPermsList(String id);
}
