package com.rianb.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rianb.todolist.model.User;
import com.rianb.todolist.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User cadastrar(User user) {
        return repository.save(user);
    }
}
