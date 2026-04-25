package com.rianb.todolist.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}