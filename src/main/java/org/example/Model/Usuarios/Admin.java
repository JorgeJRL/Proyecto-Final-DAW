package org.example.Model.Usuarios;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.example.Model.Role;

import java.util.Set;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {


    public Admin() {
    }

    public Admin(String nombre, String password, String email, String apellidos, Set<Role> roles) {
        super(nombre, password, email, apellidos, roles);
    }


}
