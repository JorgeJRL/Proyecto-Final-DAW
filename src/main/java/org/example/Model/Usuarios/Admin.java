package org.example.Model.Usuarios;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.Model.Centro;
import org.example.Model.Role;

import java.util.Set;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    @ManyToOne
    @JoinColumn(name = "idCentro")
    private Centro centro;


    public Admin() {
    }

    public Admin(String nombre, String password, String email, String apellidos, Set<Role> roles,  Centro centro) {
        super(nombre, password, email, apellidos, roles);
        this.centro = centro;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }
}
