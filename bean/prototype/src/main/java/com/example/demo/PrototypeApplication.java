package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrototypeApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Message message1 = context.getBean(Message.class);
        System.out.println("Message 1: " + message1); // This will invoke the overridden toString() method

        Message message2 = context.getBean(Message.class);
        System.out.println("Message 2: " + message2); // This will also invoke the overridden toString() method

        context.close();
    }
}

