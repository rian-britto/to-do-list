package com.rianb.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.rianb.todolist.exception.ResourceNotFoundException;
import com.rianb.todolist.model.Task;
import com.rianb.todolist.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task criar(Task task) {
        return repository.save(task);
    }

    public List<Task> listar() {
        return repository.findAll();
    }

    public void deletar(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task não encontrada"));

        repository.delete(task);
    }

    public Task atualizar(Long id, Task novaTask) {
        Task task = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task não encontrada"));

        task.setTitle(novaTask.getTitle());
        task.setConcluida(novaTask.isConcluida());

        return repository.save(task);
    }
}