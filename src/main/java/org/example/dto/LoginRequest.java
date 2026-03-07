package org.example.dto;

public record LoginRequest (
    String nombre,
    String password){}