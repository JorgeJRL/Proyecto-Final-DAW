package org.example.dto.Login;


import java.util.List;

public record LoginResponse (
    String token,
    String username,
    List<String> roles){}