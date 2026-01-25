package org.example.DTO.Rutas;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;
import java.util.ArrayList;
//Para el futuro cuando se creen las relaciones
public record RutasRequest(@Id
                           @GeneratedValue(strategy = GenerationType.IDENTITY)
                            int idRuta,

                                    String nombre,

                                    ArrayList<LocalTime>horarioLlegada,


                                    ArrayList<LocalTime> horarioSalida,

                                    boolean estado) {
}
