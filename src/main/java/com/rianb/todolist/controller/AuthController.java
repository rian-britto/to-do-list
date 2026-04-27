package com.rianb.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rianb.todolist.dto.LoginRequest;
import com.rianb.todolist.model.User;
import com.rianb.todolist.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return service.login(request);
    }
}