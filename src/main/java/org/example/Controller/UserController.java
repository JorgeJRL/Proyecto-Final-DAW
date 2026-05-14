package org.example.Controller;

import org.example.Service.UserService;
import org.example.dto.Rutas.RutasResponse;
import org.example.dto.User.Alumno.AlumnoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    private UserService us;

    // Obtener rutas favoritas de un alumno
    @GetMapping("/alumno/{idAlumno}/rutas-favoritas")
    public ResponseEntity<List<RutasResponse>> getRutasFavoritas(@PathVariable int idAlumno) {
        return ResponseEntity.ok(us.getRutasFavoritas(idAlumno));
    }

    // Añadir ruta favorita a un alumno
    @PostMapping("/alumno/{idAlumno}/rutas-favoritas/{idRuta}")
    public ResponseEntity<?> addRutaFavorita(@PathVariable int idAlumno, @PathVariable int idRuta) {
        us.anadirRutaFavorita(idAlumno, idRuta);
        return ResponseEntity.ok("Ruta añadida a favoritos");
    }

    // Obtener hijos asociados a una familia
    @GetMapping("/familia/{idFamilia}/hijos")
    public ResponseEntity<List<AlumnoResponse>> getHijosAsociados(@PathVariable int idFamilia) {
        return ResponseEntity.ok(us.getAlumnosAsociados(idFamilia));
    }

    // Eliminar ruta favorita de un alumno
    @DeleteMapping("/alumno/{idAlumno}/rutas-favoritas/{idRuta}")
    public ResponseEntity<?> deleteRutaFavorita(@PathVariable int idAlumno, @PathVariable int idRuta) {
        us.eliminarRutaFavorita(idAlumno, idRuta);
        return ResponseEntity.ok("Ruta eliminada de favoritos");
    }

    // Ver alumnos de un centro
    @GetMapping("/centro/{idCentro}/alumnos")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AlumnoResponse>> verTotalAlumnos(@PathVariable int idCentro) {
        return ResponseEntity.ok(us.verTotalAlumnos(idCentro));
    }
}
