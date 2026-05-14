package org.example.dto.Avisos;

import org.example.Model.TipoAviso;

import java.time.LocalDateTime;

public record AvisoResponseDTO(String mensaje,
                               int gravedad,
                               TipoAviso tipo,
                               LocalDateTime fechaHora,
                               String nombreRuta,
                               String nombreAdmin) {
}
