package com.atguigu.system.service;

import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author: longcz
 * @Date: 2022/11/7 - 11 - 07 - 1:13
 * @Description: com.atguigu.system.service
 * @version: 1.0
 */
public interface LoginLogService {

      void recordLogin(String username, Integer status, String ipaddr, String message);

    IPage<SysLoginLog> getPage(Long page, Long limit, SysLoginLogQueryVo sysLoginLogQueryVo);

}
