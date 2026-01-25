package org.example.Controller;

import jakarta.validation.Valid;
import org.example.Model.Rutas;
import org.example.Service.RutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutas")
public class RutasController {
    @Autowired
    RutasService rs;

    @GetMapping("/")
    public ResponseEntity<List<Rutas>> getRutas(){
        return ResponseEntity.ok(rs.getRutas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rutas> getRutas(@PathVariable int id){
        return ResponseEntity.ok(rs.getRuta(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Rutas ruta){
        return ResponseEntity.status(HttpStatus.CREATED).body(rs.addRutas(ruta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Rutas ruta, @PathVariable int id) {
        try{
            return ResponseEntity.ok(rs.editRutas(ruta, id));
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
