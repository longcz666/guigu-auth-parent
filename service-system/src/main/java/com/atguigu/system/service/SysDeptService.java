package com.atguigu.system.service;

import com.atguigu.model.system.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 25986
* @description 针对表【sys_dept(组织机构)】的数据库操作Service
* @createDate 2022-11-09 23:50:26
*/
public interface SysDeptService extends IService<SysDept> {

    List<SysDept> findNodes();

    boolean removeDeptById(Long id);
}
