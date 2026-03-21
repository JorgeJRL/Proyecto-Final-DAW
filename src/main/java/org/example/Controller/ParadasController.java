package org.example.Controller;

import org.example.Service.ParadasService;

import org.example.dto.Paradas.ParadasRequest;
import org.example.dto.Paradas.ParadasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paradas")
public class ParadasController {
    @Autowired
    ParadasService ps;

    @GetMapping("/")
    public ResponseEntity<List<ParadasResponse>> getParadas(){
        return ResponseEntity.ok(ps.getParadas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParadasResponse> getParada(@PathVariable int id){
        return ResponseEntity.ok(ps.getParada(id));
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ParadasResponse create(@RequestBody ParadasRequest request){
        return ps.addParada(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ParadasResponse> update(@PathVariable int id, @RequestBody ParadasRequest request) {
            return ResponseEntity.ok(ps.editParadas(request, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable int id){
        try{
            ps.removeParadas(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso no encontrado");
        }
    }

}
