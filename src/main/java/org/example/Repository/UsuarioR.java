package org.example.Repository;
import org.example.Model.Usuarios.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioR extends JpaRepository<User, Long> {

    Optional<User> findByNombre(String nombre);
}
