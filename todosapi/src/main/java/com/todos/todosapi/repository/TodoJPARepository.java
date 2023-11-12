package com.todos.todosapi.repository;

import org.springframework.stereotype.Repository;
import com.todos.todosapi.model.Todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Integer> {

	
	List<Todo> findByTitle(String title);

}