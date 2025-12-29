package org.example.Repository;

import org.example.Model.Usuarios.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoR extends JpaRepository<Alumno, Long> {
    // Métodos personalizados si es necesario
}