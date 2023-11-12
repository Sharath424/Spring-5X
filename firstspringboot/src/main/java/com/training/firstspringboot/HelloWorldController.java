package com.training.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	HelloWeb helloWeb;
	
	@GetMapping()
	public String defaultWeb() {
		return "Hello world";
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello web";
		
	}
	
	@GetMapping("/helloweb")
	public HelloWeb sayHelloWithObject() {
		helloWeb.setId(1);
		helloWeb.setMessage("Hello web!");
		return helloWeb;
		
	}
}
