package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.atguigu.system.mapper.LoginLogMapper;
import com.atguigu.system.service.LoginLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: longcz
 * @Date: 2022/11/7 - 11 - 07 - 16:26
 * @Description: com.atguigu.system.service.impl
 * @version: 1.0
 */

@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl implements LoginLogService {

    private final LoginLogMapper loginLogMapper;

    @Override
    public void recordLogin(String username, Integer status, String ipaddr, String message) {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(username);
        sysLoginLog.setStatus(status);
        sysLoginLog.setMsg(message);
        sysLoginLog.setIpaddr(ipaddr);
        loginLogMapper.insert(sysLoginLog);
    }

    @Override
    public IPage<SysLoginLog> getPage(Long page, Long limit, SysLoginLogQueryVo sysLoginLogQueryVo) {
        Page<SysLoginLog> page1 = new Page(page, limit);
        String username = sysLoginLogQueryVo.getUsername();
        String createTimeBegin = sysLoginLogQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysLoginLogQueryVo.getCreateTimeEnd();
        LambdaQueryWrapper<SysLoginLog> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(username)){
            wrapper.like(SysLoginLog::getUsername,username);
        }
        if (!StringUtils.isEmpty(createTimeBegin)){
            wrapper.ge(SysLoginLog::getCreateTime,createTimeBegin);
        }
        if (!StringUtils.isEmpty(createTimeEnd)){
            wrapper.le(SysLoginLog::getCreateTime,createTimeEnd);
        }
        return loginLogMapper.selectPage(page1, wrapper);
    }
}
