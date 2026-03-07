package org.example.Repository.Usuarios;

import org.example.Model.Usuarios.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminR extends JpaRepository<Admin, Integer> {
    // Métodos personalizados si es necesario
}
