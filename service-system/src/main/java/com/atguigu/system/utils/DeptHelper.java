package com.atguigu.system.utils;

import com.atguigu.model.system.SysDept;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: longcz
 * @Date: 2022/11/10 - 11 - 10 - 21:10
 * @Description: com.atguigu.system.utils
 * @version: 1.0
 */
public class DeptHelper {
    //构建树形
    public static List<SysDept> buildTree(List<SysDept> sysDeptList) {
        ArrayList<SysDept> trees = new ArrayList<>();
        for (SysDept sysDept : sysDeptList) {
            if (sysDept.getParentId() == 0) {
                trees.add(findChildren(sysDept, sysDeptList));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param sysDept,treeNodes
     * @return SysMenu对象
     */
    private static SysDept findChildren(SysDept sysDept, List<SysDept> treeNodes) {
        sysDept.setChildren(new ArrayList<>());
        for (SysDept item : treeNodes) {
            //获取当前菜单id
            Long id = Long.valueOf(sysDept.getId());
            //获取所有菜单parentId
            Long parentId = item.getParentId();
            if (id.equals(parentId)) {
                if (Objects.isNull(sysDept.getChildren())) {
                    sysDept.setChildren(new ArrayList<>());
                }
                sysDept.getChildren().add(findChildren(item, treeNodes));
            }
        }
        return sysDept;
    }
}
