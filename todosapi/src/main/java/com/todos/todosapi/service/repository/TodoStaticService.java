package com.todos.todosapi.service.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todos.todosapi.model.Todo;
import com.todos.todosapi.service.ITodoService;

//@Service
public class TodoStaticService implements ITodoService {

	private static List<Todo> todos = new ArrayList<>();

	static {
		todos.add(new Todo(1, "Learn Java", "From Scratch", false, new Date()));
		todos.add(new Todo(2, "Learn Spring", "From Scratch", false, new Date()));
		todos.add(new Todo(3, "Learn Hibernet", "From Scratch", false, new Date()));
	}

	@Override
	public List<Todo> getAllTodos() {
		return todos;
	}

	@Override
	public Todo getById(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	

	@Override
	public Todo addTodo(Todo todo) {
		todo.setId(findMaxTodoId() + 1);
		todos.add(todo);
		return todo;
	}

	@Override
	public Todo updateTodo(int id, Todo todo) {
		Todo oldTodo = getById(id);
		if (oldTodo != null) {
			todos.remove(oldTodo);
			todos.add(todo);
		}
		return todo;
	}

	@Override
	public Todo deleteTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				todos.remove(todo);
				return todo;
			}
		}
		return null;
	}

	private int findMaxTodoId() {
		return 3;
	}
	
	@Override
	public List<Todo> getByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
