package com.security.session.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author : OlinH
 * @version : v1.0
 * @className : ApplicationConfig
 * @packageName : com.security.session.config
 * @description : 应用配置类
 * @since : 2020/10/25
 *
 * <p>{@code @Configuration}相当于application-context.xml配置文件，对应web.xml中ContextLoaderListener的配置</p>
 */
@Configuration
@ComponentScan(basePackages = "com.security.session"
                , excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {

    // 在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等。
}
