package org.example.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.Model.Usuarios.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final String SECRET_KEY = "1234";

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getNombre())
                .claim(
                        "roles",
                        user.getRoles()
                                .stream()
                                .map(r -> r.getRol())
                                .collect(Collectors.toList())
                )
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}