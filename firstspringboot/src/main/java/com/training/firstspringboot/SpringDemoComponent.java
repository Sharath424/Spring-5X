package com.training.firstspringboot;

import org.springframework.stereotype.Component;

//@Component
public class SpringDemoComponent {
	
	public SpringDemoComponent() {
		System.out.println("*********Constructor or SpringDemoComponent use called****");
	}
	
	public String getMessage() {
		return "Hello from SpringDemoComponent get message";
	}

}
