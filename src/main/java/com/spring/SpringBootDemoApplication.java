package com.spring;

import com.spring.dbstarter.EnableDbCount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//Custom Enable Annotation
@EnableDbCount
public class SpringBootDemoApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Bean
    public StartupRunner schedulerRunner() {
        return new StartupRunner();
    }
}