package org.example.Repository.Usuarios;

import org.example.Model.Usuarios.Familias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaR extends JpaRepository<Familias, Integer> {
    // Métodos personalizados si es necesario
}
