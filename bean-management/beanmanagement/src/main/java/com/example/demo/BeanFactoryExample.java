package com.example.demo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryExample {
    public static void main(String[] args) {
        // Load the Spring configuration file
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        // Retrieve the bean from the BeanFactory
        Person person = (Person) factory.getBean("person");

        // Use the bean
        System.out.println("Person's name: " + person.getName());
    }
}
