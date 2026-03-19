package org.example.Controller;

import jakarta.validation.Valid;
import org.example.DTO.User.UserRequest;
import org.example.Security.JwtService;
import org.example.Service.AuthService;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private AuthService as;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService us;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.nombre(),
                request.password()
        );

        authenticationManager.authenticate(authentication);

        UserDetails user = us.loadUserByUsername(request.nombre());
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(token);
    }
}
