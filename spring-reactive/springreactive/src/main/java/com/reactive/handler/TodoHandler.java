package com.reactive.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.dao.TodoDao;
import com.reactive.model.Todo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TodoHandler {

	@Autowired
	private TodoDao todoDao;
	
	
  public Mono<ServerResponse> getAllTodos(ServerRequest request) {

	  Flux<Todo> todoList=todoDao.getTodosList();
  return ServerResponse.ok().body(todoList, Todo.class);
  }

  public Mono<ServerResponse> findTodo(ServerRequest request) {
int todoId=Integer.valueOf(request.pathVariable("input"));
Mono<Todo> todoMono = todoDao.getTodosList().filter(d -> d.getId() == todoId).next();
return ServerResponse.ok().body(todoMono,Todo.class);


  }
  
  public Mono<ServerResponse> createTodo(ServerRequest request) {
	  Mono<Todo> todoMono = request.bodyToMono(Todo.class);

      Mono<String> saveResponse = todoMono.map(a -> a.getId() + ":" + a.getTitle() + ":"+ a.getDescription());
      return ServerResponse.ok().body(saveResponse,String.class);

  
  }  
  
  }





	
	

//    public TodoHandler(TodoService todoService) {
//        this.todoService = todoService;
//    }
//
//
//    public Mono<ServerResponse> getTodoById(ServerRequest request) {
//        int id = Integer.parseInt(request.pathVariable("id"));
//        return ok()
//            .contentType(MediaType.APPLICATION_JSON)
//            .body(todoService.getTodoById(id), Todo.class);
//    }

