package com.kt.springdemodatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class DemoDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDataJpaApplication.class, args);
    }

}
