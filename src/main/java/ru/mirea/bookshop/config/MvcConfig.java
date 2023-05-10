package ru.mirea.bookshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import ru.mirea.bookshop.config.interceptors.FreeMarkerInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FreeMarkerInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:///" + uploadPath + "/uploads/" );
        registry.addResourceHandler("/css/**")
                .addResourceLocations("file:///" + uploadPath + "/src/main/resources/static/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("file:///" + uploadPath + "/src/main/resources/static/js/");
    }
}
