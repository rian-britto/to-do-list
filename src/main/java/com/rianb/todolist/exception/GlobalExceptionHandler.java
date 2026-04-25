package com.rianb.todolist.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleNotFound(ResourceNotFoundException ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", 404);
        erro.put("error", "Not Found");
        erro.put("message", ex.getMessage());

        return erro;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleGeneric(Exception ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", 500);
        erro.put("error", "Internal Server Error");
        erro.put("message", "Erro inesperado");

        return erro;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> fields = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            fields.put(error.getField(), error.getDefaultMessage());
        });

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 400);
        erro.put("error", "Bad Request");
        erro.put("message", "Erro de validação");
        erro.put("fields", fields);

        return erro;
    }
}