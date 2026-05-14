package org.example.dto.RegistroViaje;

import java.time.LocalDateTime;

public record RVResponse(
        String nombreAlumno,
        String matriculaTransporte,
        LocalDateTime fechaHora,
        boolean activo
) {}
