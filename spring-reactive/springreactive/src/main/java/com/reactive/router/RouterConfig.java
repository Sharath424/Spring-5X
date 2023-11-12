package com.reactive.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.handler.TodoHandler;
import com.reactive.handler.TodoStreamHandler;

@Configuration
public class RouterConfig {

	@Autowired
	private TodoHandler handler;

	@Autowired
	private TodoStreamHandler streamHandler;

	@Bean
	public RouterFunction<ServerResponse> todoRoutes(TodoHandler handler) {
		return RouterFunctions.route().GET("/router/todo", handler::getAllTodos)
				.GET("/router/todo/stream", streamHandler::getAllTodosStream)
				.GET("/router/todo/{input}", handler::findTodo)
				.POST("/router/todo", handler::createTodo) // POST route
				.build();
	}

}
