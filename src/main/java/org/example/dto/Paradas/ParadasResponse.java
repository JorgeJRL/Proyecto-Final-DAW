package org.example.dto.Paradas;

import org.example.Model.Rutas;

public record ParadasResponse(String nombreParada,
                              double  latitud,
                              double  longitud,
                              int orden,
                              Rutas ruta
) {
}
