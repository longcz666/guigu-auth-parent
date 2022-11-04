package com.atguigu.system.service.impl;

import com.atguigu.common.utils.RouterHelper;
import com.atguigu.model.system.SysMenu;
import com.atguigu.model.system.SysRoleMenu;
import com.atguigu.model.vo.AssginMenuVo;
import com.atguigu.model.vo.RouterVo;
import com.atguigu.system.exception.MyExceptionHandler;
import com.atguigu.system.mapper.SysMenuMapper;
import com.atguigu.system.mapper.SysRoleMenuMapper;
import com.atguigu.system.service.SysMenuService;
import com.atguigu.system.utils.MenuHelper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 25986
 * @description 针对表【sys_menu(菜单表)】的数据库操作Service实现
 * @createDate 2022-11-02 22:24:06
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
        implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysMenu> findNodes() {
        List<SysMenu> sysMenuList = sysMenuMapper.selectList(null);
        //调用工具类，构建集合树
        return MenuHelper.buildTree(sysMenuList);
    }

    @Override
    public void removeMenuById(String id) {
        LambdaQueryWrapper<SysMenu> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SysMenu::getParentId, id);
        Integer count = sysMenuMapper.selectCount(lqw);
        if (count > 0) {
            throw new MyExceptionHandler(201, "请先删除子菜单");
        } else {
            sysMenuMapper.deleteById(id);
        }

    }

    @Override
    public List<SysMenu> findMenuByRoleId(String roleId) {

        System.out.println("角色id" + roleId);

        //获取所有菜单
        LambdaQueryWrapper<SysMenu> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SysMenu::getStatus, 1);
        List<SysMenu> sysMenuList = sysMenuMapper.selectList(lqw);

        //根据角色id查询角色分配的菜单id
        List<String> menuIdList = sysMenuMapper.selectRoleByMenuId(roleId);

        //对比menuIdList和所有菜单id,设置Select的状态
        for (SysMenu sysMenu : sysMenuList) {
            sysMenu.setSelect(menuIdList.contains(sysMenu.getId()));
        }

        //构建树
        return MenuHelper.buildTree(sysMenuList);
    }

    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        //根据角色id删除菜单权限
        System.out.println("角色id" + assginMenuVo.getRoleId());
        sysRoleMenuMapper.myDeleteById(assginMenuVo.getRoleId());

        //根据角色id集合给角色授权
        List<String> menuIdList = assginMenuVo.getMenuIdList();
        for (String menuId : menuIdList) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(assginMenuVo.getRoleId());
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenuMapper.insert(sysRoleMenu);
        }
    }

    @Override
    public List<RouterVo> findUserMenuList(String userId) {
        List<SysMenu> sysMenuList;

        //判断用户是否是超级管理员
        if ("1".equals(userId)) {
            LambdaQueryWrapper<SysMenu> lqw = new LambdaQueryWrapper<>();
            lqw.orderByAsc(SysMenu::getSortValue);
            sysMenuList = sysMenuMapper.selectList(lqw);
        } else {
            sysMenuList = sysMenuMapper.findMenuListByUserId(userId);
        }
        //构建树形数据
        List<SysMenu> sysMenuTreeList = MenuHelper.buildTree(sysMenuList);

        //构建路由
        return RouterHelper.buildRouters(sysMenuTreeList);
    }

    @Override
    public List<String> findUserPermsList(String userId) {
        List<SysMenu> sysMenuList;
        //判断用户是否是超级管理员
        if ("1".equals(userId)) {
            LambdaQueryWrapper<SysMenu> lqw = new LambdaQueryWrapper<>();
            lqw.eq(SysMenu::getStatus,1);
           sysMenuList = sysMenuMapper.selectList(lqw);
        }else {
           sysMenuList = sysMenuMapper.findMenuListByUserId(userId);
        }
        //遍历集合获得菜单按钮集合
        List<String> permissionList = new ArrayList<>();
        for (SysMenu sysMenu :
                sysMenuList) {
            if (sysMenu.getType() == 2){
                permissionList.add(sysMenu.getPerms());
            }
        }
        return permissionList;
    }
}




