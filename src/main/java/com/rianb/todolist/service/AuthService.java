package com.rianb.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rianb.todolist.dto.LoginRequest;
import com.rianb.todolist.exception.UnauthorizedException;
import com.rianb.todolist.model.User;
import com.rianb.todolist.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository repository;

    public String login(LoginRequest request) {

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UnauthorizedException("Email ou senha inválidos"));

        if (!user.getSenha().equals(request.getSenha())) {
            throw new UnauthorizedException("Email ou senha inválidos");
        }

        return jwtService.gerarToken(user.getEmail());
    }
}