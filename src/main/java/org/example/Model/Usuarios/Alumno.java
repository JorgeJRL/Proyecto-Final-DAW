package org.example.Model.Usuarios;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.example.Model.Role;

import java.util.Set;

@Entity
@DiscriminatorValue("ALUMNO")
public class Alumno extends User {


    private String curso;
    private String grupo;

    public Alumno() {
    }

    public Alumno( String nombre, String password, String email, String apellidos,
                  Set<Role> roles, String curso, String grupo) {

        super( nombre, password, email, apellidos, roles);
        this.curso = curso;
        this.grupo = grupo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
