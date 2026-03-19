package org.example.dto.Paradas;

import org.example.Model.Rutas;
import org.example.dto.Rutas.RutasResponse;

public record ParadasRequest(String nombreParada,
                             double  latitud,
                             double  longitud,
                             int orden,
                             Rutas ruta) {
}
