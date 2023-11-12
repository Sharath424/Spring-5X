package com.training.firstspringboot;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.training.firstspringboot")
public class FirstspringbootApplication implements CommandLineRunner{
	
	@Autowired
	SpringDemoComponent springDemoComponent;
	
	@Value("${server.port}")
	private String port; 

	public static void main(String[] args) {
//	    ConfigurableApplicationContext applicationContext =SpringApplication.run(FirstspringbootApplication.class, args);
//			SpringDemoComponent component = applicationContext.getBean(SpringDemoComponent.class);
//			System.out.println(component.getMessage());
//			
//			String[] beanNames =applicationContext.getBeanDefinitionNames();
//			Arrays.sort(beanNames);//optional
//			for(String beanName: beanNames) {
//			System.out.println(beanName);
//			
			 SpringApplication.run(FirstspringbootApplication.class, args);
			   
			
			}
			
	@Override
	public void run(String... args) throws Exception{
		System.out.println(springDemoComponent.getMessage());
		System.out.println("the server port is :"+ port);
		
	}
}
