package com.atguigu.system;

import cn.hutool.crypto.digest.DigestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: longcz
 * @Date: 2022/11/4 - 11 - 04 - 13:34
 * @Description: com.atguigu.system
 * @Version: 1.0
 */
@SpringBootTest
public class HuToolTest {

    @Test
    void test01() {
        String password = "123134";

        String md5Hex1 = DigestUtil.md5Hex(password);
        System.out.println(md5Hex1);
    }
}
