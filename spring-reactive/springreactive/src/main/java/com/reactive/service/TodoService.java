package com.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.dao.TodoDao;
import com.reactive.model.Todo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoService {

	@Autowired
	private TodoDao todoDao;

    public Mono<Todo> getTodoById(int id) {
        return todoDao.getTodoById(id); // Implement this method in TodoDao
    }
    
    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }
    
//    public Flux<Todo> loadAllTodosStream() {
//        long startTime = System.currentTimeMillis();
//        Flux<Todo> todoFlux = todoDao.getTodosStream()
//                .filter(todo -> todo.getId() % 2 == 0)
//                .map(todo -> {
//                    todo.setTitle("Modified: " + todo.getTitle());
//                    return todo;
//                })
//                .doOnNext(todo -> {
//                    // Perform an action on each element, e.g., logging.
//                    System.out.println("Processing todo: " + todo.getId());
//                })
//                .doOnComplete(() -> {
//                    long endTime = System.currentTimeMillis();
//                    System.out.println("Total time taken: " + (endTime - startTime));
//                    System.out.println("Stream completed.");
//                })
//                .doOnError(error -> {
//                    // Handle errors, e.g., log the error or perform recovery actions.
//                    System.err.println("An error occurred: " + error.getMessage());
//                });
//        return todoFlux;
//    }

    public Flux<Todo> loadAllTodosStream() {
        return todoDao.getTodosStream()
                .filter(todo -> todo.getId() % 2 == 0)
                .map(todo -> {
                    todo.setTitle("Modified: " + todo.getTitle());
                    return todo;
                });
    }
    
   
}