package com.training.firstspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstspringbootApplicationTests {

	@Autowired
	private HelloWorldController controller;

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoadsWithControllerSuccess() {
		assertThat(controller).isNotNull();
		
	}

}