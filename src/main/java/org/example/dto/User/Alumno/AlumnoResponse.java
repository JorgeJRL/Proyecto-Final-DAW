package org.example.dto.User.Alumno;

public record AlumnoResponse(
        String nombre,
        String apellidos,
        String email,
        String curso,
        String grupo,
        String centro,
        String transporte
) {
}
