package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringBoot06DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06DataJpaApplication.class, args);
    }

}
