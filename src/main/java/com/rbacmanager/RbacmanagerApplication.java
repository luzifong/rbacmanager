package com.rbacmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rbacmanager.mapper")
public class RbacmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacmanagerApplication.class, args);
    }

}
