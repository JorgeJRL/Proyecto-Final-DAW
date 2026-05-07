package org.example.Model.Usuarios;

import jakarta.persistence.*;
import org.example.Model.Role;

import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("Familia")
public class Familias extends User {

    private String direccion;
    private String telefono;
    private String telefonoEmergencia;

    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alumno> alumnos;

    public Familias() {
    }

    public Familias(String nombre, String password, String email, String apellidos, Set<Role> roles, String direccion, String telefono, String telefonoEmergencia) {
        super(nombre, password, email, apellidos, roles);
        this.direccion = direccion;
        this.telefono = telefono;
        this.telefonoEmergencia = telefonoEmergencia;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
