package org.example.Repository.Usuarios;

import org.example.Model.Rutas;
import org.example.Model.Usuarios.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoR extends JpaRepository<Alumno, Integer> {
    // Métodos personalizados si es necesario
    @Query("SELECT a.rutasFavoritas FROM Alumno a WHERE a.id = :idAlumno")
    Optional<List<Rutas>> findRutasFavoritasByAlumnoId(@Param("idAlumno") int idAlumno);

    List<Alumno> findByCentroIdCentro(int idCentro);

}