package com.andrey.todolist.repository;

import com.andrey.todolist.model.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoItem, Long> {
}