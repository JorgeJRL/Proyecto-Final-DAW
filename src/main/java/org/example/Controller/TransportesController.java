package org.example.Controller;

import org.example.Service.TransportesService;
import org.example.dto.RegistroViaje.RVResponse;
import org.example.dto.Transportes.TransportesRequest;
import org.example.dto.Transportes.TransportesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Transporte")
public class TransportesController {

    @Autowired
    TransportesService ts;

    // OBTENER
    @GetMapping
    public ResponseEntity<List<TransportesResponse>> getTransportes(@RequestParam String tipo){
        return ResponseEntity.ok(ts.getAll(tipo));
    }

    // HISTORIAL
    @GetMapping("/alumno/{idAlumno}/historial")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_FAMILIA')")
    public ResponseEntity<List<RVResponse>> getHistorialAlumno(@PathVariable int idAlumno) {
        return ResponseEntity.ok(ts.getHistorialAlumno(idAlumno));
    }

    // CREAR
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<TransportesResponse> crearTransporte(@RequestBody TransportesRequest dto) {
        return ResponseEntity.ok(ts.crearTransporte(dto));
    }

    // ACTUALIZAR
    @PutMapping("/{idTransporte}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<TransportesResponse> actualizarTransporte(@PathVariable int idTransporte, @RequestBody TransportesRequest dto) {
        return ResponseEntity.ok(ts.actualizarTransporte(idTransporte, dto));
    }

    // BORRAR
    @DeleteMapping("/{idTransporte}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> borrarTransporte(@PathVariable int idTransporte) {
        ts.borrarTransporte(idTransporte);
        return ResponseEntity.ok("Transporte eliminado correctamente");
    }

    // TICAR
    @PostMapping("/{idTransporte}/ticar/{idAlumno}/{idParada}")
    @PreAuthorize("hasRole('ROLE_ALUMNO')")
    public ResponseEntity<?> ticar(@PathVariable int idTransporte, @PathVariable int idAlumno, @PathVariable int idParada) {
        ts.ticar(idAlumno, idTransporte, idParada);
        return ResponseEntity.ok("Ticar registrado correctamente");
    }



}