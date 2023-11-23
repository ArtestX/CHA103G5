package com.cha103g5;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 確保這裡的路徑是正確的，並且與您存放圖片的目錄相匹配
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:///C:/IDEA_Workspace/Test/demo/uploads/");
    }
}
