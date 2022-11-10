package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysOperLog;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.atguigu.system.mapper.AsyncOperLogServiceMapper;
import com.atguigu.system.service.AsyncOperLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: longcz
 * @Date: 2022/11/7 - 11 - 07 - 17:51
 * @Description: com.atguigu.system.service.impl
 * @version: 1.0
 */
@Service
@RequiredArgsConstructor
public class AsyncOperLogServiceImpl implements AsyncOperLogService {

    private final AsyncOperLogServiceMapper asyncOperLogServiceMapper;

    @Override
    public void saveSysLog(SysOperLog sysOperLog) {
        asyncOperLogServiceMapper.insert(sysOperLog);
    }

    @Override
    public IPage<SysOperLog> getPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo) {
        Page<SysOperLog> operLogPage = new Page<>(page, limit);
        LambdaQueryWrapper<SysOperLog> wrapper = new LambdaQueryWrapper<>();
        String title = sysOperLogQueryVo.getTitle();
        String operName = sysOperLogQueryVo.getOperName();
        String createTimeBegin = sysOperLogQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysOperLogQueryVo.getCreateTimeEnd();
       if (!StringUtils.isEmpty(title)){
           wrapper.like(SysOperLog::getTitle,title);
       }
       if (!StringUtils.isEmpty(operName)){
           wrapper.like(SysOperLog::getOperName,operName);
       }
       if (!StringUtils.isEmpty(title)){
           wrapper.ge(SysOperLog::getCreateTime,createTimeBegin);
       }
       if (!StringUtils.isEmpty(title)){
           wrapper.like(SysOperLog::getCreateTime,createTimeEnd);
       }

        return asyncOperLogServiceMapper.selectPage(operLogPage, wrapper);
    }
}
