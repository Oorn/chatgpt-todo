package com.andrey.todolist.controller;

import com.andrey.todolist.model.TodoItem;
import com.andrey.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public Iterable<TodoItem> getAllItems() {
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TodoItem> getItemById(@PathVariable Long id) {
        return todoRepository.findById(id);
    }

    @PostMapping
    public TodoItem createItem(@RequestBody TodoItem item) {
        return todoRepository.save(item);
    }

    @PutMapping("/{id}")
    public TodoItem updateItem(@PathVariable Long id, @RequestBody TodoItem updatedItem) {
        // Check if the item exists
        if (todoRepository.existsById(id)) {
            updatedItem.setId(id);
            return todoRepository.save(updatedItem);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}