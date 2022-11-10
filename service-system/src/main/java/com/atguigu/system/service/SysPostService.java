package com.atguigu.system.service;

import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 25986
* @description 针对表【sys_post(岗位信息表)】的数据库操作Service
* @createDate 2022-11-09 23:50:13
*/
public interface SysPostService extends IService<SysPost> {

    IPage<SysPost> getPage(Long page, Long limit, SysPostQueryVo sysPostQueryVo);

    Boolean updateStatusById(Long id, Long status);
}
