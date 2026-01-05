package org.example.Repository;
import org.example.Model.Usuarios.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioR extends JpaRepository<User, Long> {
    Optional<User> findByNombre(String nombre);
}
