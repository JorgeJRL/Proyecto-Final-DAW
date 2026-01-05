package org.example.Security;

import org.example.Model.Role;
import org.example.Model.Usuarios.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.example.Repository.UsuarioR;

import java.util.stream.Collectors;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioR repo;

    public CustomUserDetailsService(UsuarioR repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String nombre)
            throws UsernameNotFoundException {

        User user = repo.findByNombre(nombre)
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
