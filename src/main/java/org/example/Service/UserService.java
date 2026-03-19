package org.example.Service;

import org.example.DTO.User.UserRequest;
import org.example.Model.Role;
import org.example.Model.Usuarios.User;
import org.example.Repository.Usuarios.UsuarioR;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UsuarioR repo;

    public UserService(UsuarioR repo) {
        this.repo = repo;
    }


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = repo.findByNombre(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new org.springframework.security.core.userdetails.User(
                user.getNombre(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(Role::getRol)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet())
        );
    }

}
