package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.atguigu.system.mapper.SysPostMapper;
import com.atguigu.system.service.SysPostService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 25986
 * @description 针对表【sys_post(岗位信息表)】的数据库操作Service实现
 * @createDate 2022-11-09 23:50:13
 */
@Service
@RequiredArgsConstructor
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost>
        implements SysPostService {

    private final SysPostMapper sysPostMapper;

    @Override
    public IPage<SysPost> getPage(Long page, Long limit, SysPostQueryVo sysPostQueryVo) {
        Page<SysPost> postPage = new Page<>(page, limit);
        String name = sysPostQueryVo.getName();
        String postCode = sysPostQueryVo.getPostCode();
        Boolean status = sysPostQueryVo.getStatus();
        LambdaQueryWrapper<SysPost> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like(SysPost::getName, name);
        }
        if (!StringUtils.isEmpty(postCode)) {
            wrapper.like(SysPost::getPostCode, postCode);
        }
        if (status) {
            wrapper.like(SysPost::getStatus, 1);
        } else {
            wrapper.like(SysPost::getStatus, 0);
        }

        return sysPostMapper.selectPage(postPage, wrapper);
    }

    @Override
    public Boolean updateStatusById(Long id, Long status) {
        return sysPostMapper.updateStatusById(id, status);
    }
}




