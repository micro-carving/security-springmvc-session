package com.security.session.config;

import com.security.session.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;

/**
 * @author : OlinH
 * @version : v1.0
 * @className : WebConfig
 * @packageName : com.security.session.config
 * @description : web配置类
 * @since : 2020/10/25
 *
 * <p>{@code WebConfig}相当于spring-mvc.xml配置文件，对应web.xml中的DispatcherServlet配置</p>
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.security.session"
        , includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {

    @Resource
    AuthenticationInterceptor authenticationInterceptor;

    /**
     * 视图解析器
     *
     * @return InternalResourceViewResolver
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 为视图添加对应的控制器
     *
     * @param registry 视图控制器注册中心
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    /**
     * 为视图添加拦截器，将需要受保护的资源路径添加至拦截器注册中心
     *
     * @param registry 视图拦截器注册中心
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/r/**");
    }
}
