package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * @Author: longcz
 * @Date: 2022/10/27 - 10 - 27 - 14:55
 * @Description: com.atguigu.system
 * @Version: 1.0
 */
@SpringBootTest
public class SystemRoleMapperTest {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    void testSelectRole(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        sysRoles.forEach(System.out::println);

    }

    @Test
    void testRole01(){

        List<SysRole> sysRoles = sysRoleMapper.selectAll();
        sysRoles.forEach(System.out::println);
    }

    @Test
    void testS(){

    }


}
