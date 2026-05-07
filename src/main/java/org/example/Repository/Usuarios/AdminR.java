package org.example.Repository.Usuarios;

import org.example.Model.Usuarios.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminR extends JpaRepository<Admin, Integer> {
    // Métodos personalizados si es necesario
}
