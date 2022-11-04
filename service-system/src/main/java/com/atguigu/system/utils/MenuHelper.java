package com.atguigu.system.utils;

import com.atguigu.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: longcz
 * @Date: 2022/11/3 - 11 - 03 - 20:28
 * @Description: com.atguigu.system.utils
 * @Version: 1.0
 */
public class MenuHelper {

    //构建树形
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        ArrayList<SysMenu> trees = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            if (sysMenu.getParentId() == 0) {
                trees.add(findChildren(sysMenu, sysMenuList));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param sysMenu,treeNodes
     * @return SysMenu对象
     */
    private static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {
        sysMenu.setChildren(new ArrayList<>());
        for (SysMenu item : treeNodes) {
            //获取当前菜单id
            Long id = Long.valueOf(sysMenu.getId());
            //获取所有菜单parentId
            Long parentId = item.getParentId();
            if (id.equals(parentId)) {
                if (Objects.isNull(sysMenu.getChildren())) {
                    sysMenu.setChildren(new ArrayList<>());
                }
                sysMenu.getChildren().add(findChildren(item, treeNodes));
            }
        }
        return sysMenu;
    }


}
