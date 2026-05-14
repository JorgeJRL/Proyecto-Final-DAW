package org.example.dto.Avisos;

import org.example.Model.TipoAviso;

import java.time.LocalDateTime;

public record AvisoRequestDTO(String mensaje,
                              int gravedad,
                              TipoAviso tipo,
                              LocalDateTime fechaHora,
                              int idRuta,
                              int idAdmin) {
}
