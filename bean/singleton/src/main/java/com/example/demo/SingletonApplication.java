package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Counter counter1 = context.getBean(Counter.class);
        System.out.println("Counter 1: " + counter1); // Print the object, will invoke toString() method
        counter1.increment();
        System.out.println("Counter 1 - After Increment: " + counter1);

        Counter counter2 = context.getBean(Counter.class);
        System.out.println("Counter 2: " + counter2);

        context.close();
    }
}



