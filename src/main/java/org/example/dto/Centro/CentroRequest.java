package org.example.dto.Centro;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.example.Model.Transportes;

import java.util.List;

public record CentroRequest(String nombre,
                            String direccion,
                            int telefono,
                            String email,
                            List<Transportes> transportes) {
}
