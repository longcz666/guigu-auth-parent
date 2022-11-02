package com.atguigu.system;

import com.atguigu.system.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: longcz
 * @Date: 2022/11/1 - 11 - 01 - 17:36
 * @Description: com.atguigu.system
 * @Version: 1.0
 */
@SpringBootTest
public class SystemUserMapperTest {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    void test01(){
        sysUserMapper.updateStatus(1L,0L);
    }
}
