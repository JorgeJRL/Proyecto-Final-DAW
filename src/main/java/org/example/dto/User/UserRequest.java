package org.example.DTO.User;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(@Column(name = "nombre")
                          @NotNull(message = "El campo nickName no puede quedarse vacio")
                          @Size(min=3)
                          String nombre,
                          @Column(name="password", nullable = false)
                          @NotBlank(message = "El campo password no puede quedarse vacio")
                          @Size(min=5)
                          String password) {
}
