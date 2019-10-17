package com.nic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.nic.dal.mapper"})
class NicManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NicManagerApplication.class, args);
    }

}
