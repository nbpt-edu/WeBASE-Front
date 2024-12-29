package com.webank.webase.front.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web 配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 前端目录
        registry.addResourceHandler(
            "/static/,classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 配置全局CORS支持
        registry.addMapping("/**")  // 允许所有路径
                .allowedOrigins("http://localhost:3010") // 允许来自http://localhost:8081的请求
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的HTTP方法
                .allowedHeaders("*")  // 允许所有请求头
                .allowCredentials(true);  // 是否允许携带凭证（如cookies）
    }
}

