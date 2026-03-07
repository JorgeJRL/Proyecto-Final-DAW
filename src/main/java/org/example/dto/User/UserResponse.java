package org.example.DTO.User;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserResponse(@Id
                           @GeneratedValue(strategy = GenerationType.IDENTITY)
                           @Column(name = "id_usuario")
                           int idUsers,

                           @Column(name = "nombre")
                           @NotNull(message = "El campo nickName no puede quedarse vacio")
                           @Size(min = 3)
                           String nombre,

                           @Column(name = "password", nullable = false)
                           @NotBlank(message = "El campo password no puede quedarse vacio")
                           @Size(min = 5)
                           String password,

                           @Column(name = "email", nullable = false, unique = true)
                           @NotBlank(message = "El campo email no puede quedar vacio")
                           @Email
                           String email,

                           @Column(name = "apellidos", nullable = false)
                           @NotBlank(message = "El campo apellidos no puede quedarse vacio")
                           String apellidos) {
}
