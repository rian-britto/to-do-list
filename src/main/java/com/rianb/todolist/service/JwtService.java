package com.rianb.todolist.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Service
public class JwtService {
    private final Key SECRET = Keys.hmacShaKeyFor("segredo-super-seguro-seguro-123456".getBytes());

    public String gerarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1h
                .signWith(SECRET)
                .compact();

    }
}
