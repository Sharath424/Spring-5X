package com.training.firstspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
	@Conditional(MyCondition.class)
	public SpringDemoComponent createBean() {
		return new SpringDemoComponent();
	}
}
