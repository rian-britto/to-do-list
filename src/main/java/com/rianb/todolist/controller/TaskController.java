package com.rianb.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rianb.todolist.model.Task;
import com.rianb.todolist.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository repository;

    @PostMapping
    public Task criar(@RequestBody Task task) {
        return repository.save(task);
    }

    @GetMapping
    public List<Task> listar() {
        return repository.findAll();
    }
}
