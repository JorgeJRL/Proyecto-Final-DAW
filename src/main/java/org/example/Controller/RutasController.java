package org.example.Controller;

import jakarta.validation.Valid;
import org.example.Model.Rutas;
import org.example.Repository.RutasR;
import org.example.Service.RutasService;
import org.example.dto.Rutas.RutasRequest;
import org.example.dto.Rutas.RutasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutas")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RutasController {
    @Autowired
    RutasService rs;

    @GetMapping("/")
    public ResponseEntity<List<RutasResponse>> getRutas(){
        return ResponseEntity.ok(rs.getRutas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutasResponse> getRutas(@PathVariable int id){
        return ResponseEntity.ok(rs.getRuta(id));
    }

    @PostMapping("/")
    public RutasResponse create(@RequestBody RutasRequest request){
        return rs.addRutas(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestBody RutasRequest request) {
        try{
            return ResponseEntity.ok(rs.editRutas(request, id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try{
            rs.removeRutas(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso no encontrado");
        }
    }
}
