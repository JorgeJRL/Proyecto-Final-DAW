package org.example.Repository;

import org.example.Model.Usuarios.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminR extends JpaRepository<Admin, Long> {
    // Métodos personalizados si es necesario
}
