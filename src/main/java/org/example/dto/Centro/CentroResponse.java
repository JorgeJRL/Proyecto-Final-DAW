package org.example.dto.Centro;

import org.example.Model.Transportes;

import java.util.List;

public record CentroResponse(String nombre,
                             String direccion,
                             int telefono,
                             String email,
                             List<Transportes> transportes) {
}
