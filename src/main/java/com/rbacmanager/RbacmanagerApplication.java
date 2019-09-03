package com.rbacmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@MapperScan("com.rbacmanager.mapper")
public class RbacmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacmanagerApplication.class, args);
    }
    @Bean
    public InternalResourceViewResolver setUpViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
