package com.reactive.dao;

import java.time.Duration;

import org.springframework.stereotype.Component;

import com.reactive.model.Todo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TodoDao {
	public Flux<Todo> getTodosStream(){
        return Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count : " + i))
                .map(i -> new Todo(i, "Todo " + i, "Desc " + i));

    }

	public Mono<Todo> getTodoById(int id) {
		// TODO Auto-generated method stub
		return getTodosStream().filter(todo -> todo.getId() == id).next();
			}
	
	public Flux<Todo> getTodosList(){
	    return Flux.range(1, 50)
                .doOnNext(i -> System.out.println("processing count : " + i))
	            .map(i -> new Todo(i, "Todo " + i, "Desc " + i));

	}
	
	
	}



