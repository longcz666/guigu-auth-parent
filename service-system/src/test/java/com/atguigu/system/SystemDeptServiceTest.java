package com.atguigu.system;

import com.atguigu.model.system.SysDept;
import com.atguigu.system.service.SysDeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: longcz
 * @Date: 2022/11/10 - 11 - 10 - 21:29
 * @Description: com.atguigu.system
 * @version: 1.0
 */
@SpringBootTest
public class SystemDeptServiceTest {

    @Autowired
    private SysDeptService sysDeptService;


    @Test
    void test01() {
        List<SysDept> nodes = sysDeptService.findNodes();
        System.out.println(nodes);
    }

}
