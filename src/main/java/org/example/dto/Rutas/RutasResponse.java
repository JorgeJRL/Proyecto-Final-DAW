package org.example.dto.Rutas;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;
import java.util.ArrayList;

public record RutasResponse(
                            String nombre,

                            ArrayList<LocalTime> horarioLlegada,

                            ArrayList<LocalTime> horarioSalida,

                            boolean estado) {
}
