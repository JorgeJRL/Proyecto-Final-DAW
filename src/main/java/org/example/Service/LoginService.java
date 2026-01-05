package org.example.Service;

import org.example.Model.Usuarios.User;
import org.example.Repository.UsuarioR;
import org.example.dto.LoginRequest;
import org.example.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UsuarioR usuarioR;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {

        User usuario = usuarioR
                .findByNombre(request.getNombre())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(usuario);

        return new LoginResponse(
                token,
                usuario.getNombre(),
                usuario.getRoles()
                        .stream()
                        .map(rol -> rol.getRol())
                        .toList()
        );
    }
}
