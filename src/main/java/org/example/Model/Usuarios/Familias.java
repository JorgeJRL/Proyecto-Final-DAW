package org.example.Model.Usuarios;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.example.Model.Role;

import java.util.Set;

@Entity
@DiscriminatorValue("Familia")
public class Familias extends User {

    private String direccion;
    private String telefono;
    private String telefonoEmergencia;


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
}
