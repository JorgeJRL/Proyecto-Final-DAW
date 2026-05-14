package org.example.Controller;

import org.example.Service.AvisosService;
import org.example.dto.Avisos.AvisoRequestDTO;
import org.example.dto.Avisos.AvisoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Avisos")
public class AvisosController {

    @Autowired
    AvisosService as;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AvisoResponseDTO>> getAll() {
        return ResponseEntity.ok(as.getAll());
    }

    @GetMapping("/usuario/{idUsuario}/avisos")
    @PreAuthorize("hasRole('ROLE_ALUMNO') or hasRole('ROLE_FAMILIA')")
    public ResponseEntity<List<AvisoResponseDTO>> getAvisosUsuario(@PathVariable int idUsuario) {
        return ResponseEntity.ok(as.getAvisosByUsuario(idUsuario));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AvisoResponseDTO> crearAviso(@RequestBody AvisoRequestDTO dto) {
        return ResponseEntity.ok(as.crearAviso(dto));
    }

    @PutMapping("/{idAviso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AvisoResponseDTO> modificarAviso(@PathVariable int idAviso, @RequestBody AvisoRequestDTO dto) {
        return ResponseEntity.ok(as.modificarAviso(idAviso, dto));
    }

    @DeleteMapping("/{idAviso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> borrarAviso(@PathVariable int idAviso) {
        as.borrarAviso(idAviso);
        return ResponseEntity.ok("Aviso eliminado correctamente");
    }
}
