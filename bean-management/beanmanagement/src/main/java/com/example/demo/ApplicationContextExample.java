package com.example.demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExample {
    public static void main(String[] args) {
        // Load the Spring configuration file using ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieve the bean from the ApplicationContext
        Person person = context.getBean("person", Person.class);

        // Use the bean
        System.out.println("Person's name: " + person.getName());
    }
}
