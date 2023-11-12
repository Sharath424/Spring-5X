package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class AppConfig {
    @Bean
    @RequestScope
    public User user() {
        return new User("Swayaan");
    }
}