package com.training.firstspringboot;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class HelloResourceControllerWebLayerTest {

	@Autowired
	public MockMvc mockMvc;

	@Test
	public void sayHelloShouldReturnDefaultMessage() throws Exception{
		this .mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello web")));
	}
}
