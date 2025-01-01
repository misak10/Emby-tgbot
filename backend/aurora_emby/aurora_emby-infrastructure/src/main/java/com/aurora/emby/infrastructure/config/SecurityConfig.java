package com.aurora.emby.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().disable()  // 禁用表单登录
                .httpBasic().disable()   // 禁用 HTTP Basic
                .csrf().disable()        // 禁用 CSRF 防护
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/webhook").permitAll()  // 显式允许 POST 请求
                .anyRequest().permitAll()  // 允许其他请求无需认证
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // 禁用 Session 管理
    }
}




