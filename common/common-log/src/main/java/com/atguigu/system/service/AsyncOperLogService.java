package com.atguigu.system.service;

import com.atguigu.model.system.SysOperLog;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author: longcz
 * @Date: 2022/11/7 - 11 - 07 - 17:46
 * @Description: com.atguigu.system.service
 * @version: 1.0
 */
public interface AsyncOperLogService {
    void saveSysLog(SysOperLog sysOperLog);

    IPage<SysOperLog> getPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo);
}
