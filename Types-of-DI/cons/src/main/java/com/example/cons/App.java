package com.example.cons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Technology technology = context.getBean("technology", Technology.class);

        technology.start();
    }
}