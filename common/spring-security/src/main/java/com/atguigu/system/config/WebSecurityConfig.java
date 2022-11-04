package com.atguigu.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: longcz
 * @Date: 2022/11/4 - 11 - 04 - 23:41
 * @Description: com.atguigu.system.config
 * @Version: 1.0
 */
@Configuration
@EnableWebSecurity //@EnableWebSecurity是开启SpringSecurity的默认行为
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


}