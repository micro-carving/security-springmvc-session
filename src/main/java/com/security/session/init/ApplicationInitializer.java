package com.security.session.init;

import com.security.session.config.ApplicationConfig;
import com.security.session.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author : OlinH
 * @version : v1.0
 * @className : ApplicationInitializer
 * @packageName : com.security.session.init
 * @description : 应用程序初始化器
 * @since : 2020/10/25
 *
 * <p>{@code ApplicationInitializer}相当于web.xml配置文件，使用了servlet3.0开发则不需要再定义web.xml配置文件</p>
 * web.xml配置如下所示：<br>
 * <xmp>
 *     <web-app>
 *         <listener>
 *             <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 *         </listener>
 *         <context-param>
 *              <param-name>contextConfigLocation</param-name>
 *              <param-value>/WEB-INF/application-context.xml</param-value>
 *         </context-param>
 *         <servlet>
 *              <servlet-name>spring-mvc</ servlet- name>
 *              <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 *              <init-param>
 *                   <param- name>contextConfigLocation</param-name>
 *                   <param-value>/WEB-INF/spring-mvc.xml</param-value>
 *              </init- param>
 *              <load-on-startup>1</load-on-startup>
 *          </servlet>
 *          <servlet-mapping>
 *              <servlet-name>spring-mvc</servlet-name>
 *              <url-pattern>/</url-pattern>
 *          </servlet-mapping>
 *     </web-app>
 * </xmp>
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定rootContext的配置类，相当于加载applicationContext.xml配置文件
     *
     * @return {Class类型的数组}
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    /**
     * 指定servletContext的配置类，相当于加载spring-mvc.xml
     *
     * @return {Class类型的数组}
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * url-mapping(路径映射)
     *
     * @return {String类型的数组}
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
