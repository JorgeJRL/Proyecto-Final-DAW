package org.example.Repository;

import org.example.Model.Paradas;
import org.example.Model.RegistroViaje;
import org.example.Model.Usuarios.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RegistroViajeR extends JpaRepository<RegistroViaje, Integer> {
    // Métodos personalizados si es necesario
    /** Encuentra el alumno por el id y que tico */
    Optional<RegistroViaje> findByAlumnoAndActivoTrue(Alumno alumno);
    List<RegistroViaje> findByAlumno(Alumno alumno); // historial completo

    /** Encuentra la parada por el id y que este activa */
    List<RegistroViaje> findByParadaAndActivoTrue(Paradas parada);

}
