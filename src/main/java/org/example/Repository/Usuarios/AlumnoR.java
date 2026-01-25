package org.example.Repository.Usuarios;

import org.example.Model.Usuarios.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoR extends JpaRepository<Alumno, Integer> {
    // Métodos personalizados si es necesario
}