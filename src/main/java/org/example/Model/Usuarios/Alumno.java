package org.example.Model.Usuarios;

import jakarta.persistence.*;
import org.example.Model.Centro;
import org.example.Model.Role;
import org.example.Model.Rutas;
import org.example.Model.Transportes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("ALUMNO")
public class Alumno extends User {


    private String curso;
    private String grupo;

    @ManyToOne
    @JoinColumn(name = "idCentro")
    private Centro centro;

    @ManyToOne
    @JoinColumn(name = "idFamilia")
    private Familias familia;

    @ManyToOne
    @JoinColumn(name = "idTransporte")
    private Transportes transportes;

    @ManyToMany
    @JoinTable(name = "alumno_rutas_favoritas",
            joinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "ruta_id"))
    private List<Rutas> rutasFavoritas = new ArrayList<>();

    public Alumno() {
    }

    public Alumno(String nombre, String password, String email, String apellidos, Set<Role> roles, String curso, String grupo, Centro centro, Familias familia, Transportes transportes, List<Rutas> rutasFavoritas) {
        super(nombre, password, email, apellidos, roles);
        this.curso = curso;
        this.grupo = grupo;
        this.centro = centro;
        this.familia = familia;
        this.transportes = transportes;
        this.rutasFavoritas = rutasFavoritas;
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

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    public Familias getFamilia() {
        return familia;
    }

    public void setFamilia(Familias familia) {
        this.familia = familia;
    }

    public Transportes getTransportes() {
        return transportes;
    }

    public void setTransportes(Transportes transportes) {
        this.transportes = transportes;
    }

    public List<Rutas> getRutasFavoritas() {
        return rutasFavoritas;
    }

    public void setRutasFavoritas(List<Rutas> rutasFavoritas) {
        this.rutasFavoritas = rutasFavoritas;
    }
}
