package com.example.demo.client;

public class GitClientNotFoundException extends RuntimeException{
    public GitClientNotFoundException(String message) {
        super(message);
    }
}
