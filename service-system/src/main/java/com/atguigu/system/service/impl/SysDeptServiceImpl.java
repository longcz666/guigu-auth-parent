package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysDept;
import com.atguigu.system.mapper.SysDeptMapper;
import com.atguigu.system.service.SysDeptService;
import com.atguigu.system.utils.DeptHelper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 25986
* @description 针对表【sys_dept(组织机构)】的数据库操作Service实现
* @createDate 2022-11-09 23:50:26
*/
@Service
@RequiredArgsConstructor
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept>
    implements SysDeptService{

    private final SysDeptMapper sysDeptMapper;

    @Override
    public List<SysDept> findNodes() {
        List<SysDept> deptList = sysDeptMapper.selectList(null);
        return DeptHelper.buildTree(deptList);
    }

    @Override
    public boolean removeDeptById(Long id) {
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysDept::getParentId,id);
        Integer count = sysDeptMapper.selectCount(wrapper);
        if (count > 0){
            throw new RuntimeException("请先删除子部门");
        }else{
            int i = sysDeptMapper.deleteById(id);
            return i > 0;
        }
    }
}




