package com.reactive.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.dao.TodoDao;
import com.reactive.model.Todo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TodoStreamHandler {

	@Autowired
	private TodoDao todoDao;
	

  public Mono<ServerResponse> getAllTodosStream(ServerRequest request) {

	  Flux<Todo> todoList=todoDao.getTodosList();
  return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
		  .body(todoList, Todo.class);
  }
	
	
}