package org.example.Repository.Usuarios;
import org.example.Model.Usuarios.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioR extends JpaRepository<User, Integer> {

    Optional<User> findByNombre(String nombre);
}
