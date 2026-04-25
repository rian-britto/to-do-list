package com.rianb.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rianb.todolist.model.Task;
import com.rianb.todolist.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public Task criar(@Valid @RequestBody Task task) {
        return service.criar(task);
    }

    @GetMapping
    public List<Task> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Task atualizar(@PathVariable Long id, @RequestBody Task task) {
        return service.atualizar(id, task);
    }
}
