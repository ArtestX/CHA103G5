package com.cha103g5;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")  // 允許任何來源（請依實際需要限制）
                .allowedMethods("GET", "POST", "PUT", "DELETE");  // 允許的 HTTP 方法
    }
}