package com.nic;

import com.nic.auth.TokenArgumentResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = {"com.nic.dal.mapper"})
@ComponentScan(basePackages = {"com.nic", "com.hmf.common"})
public class NicManagerApplication implements WebMvcConfigurer {

    @Resource
    private TokenArgumentResolver tokenArgumentResolver;

    public static void main(String[] args) {
        SpringApplication.run(NicManagerApplication.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(tokenArgumentResolver);
    }

}
