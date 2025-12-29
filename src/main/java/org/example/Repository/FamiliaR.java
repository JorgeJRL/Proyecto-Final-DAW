package org.example.Repository;

import org.example.Model.Usuarios.Familias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaR extends JpaRepository<Familias, Long> {
    // Métodos personalizados si es necesario
}
