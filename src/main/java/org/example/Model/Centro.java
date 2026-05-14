package org.example.Model;

import jakarta.persistence.*;
import org.example.Model.Usuarios.Admin;

import java.util.List;

@Entity
public class Centro {

    /// No entiendo lo del id_usuario para que queremmos los usuarios

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCentro;

    private String nombre;

    private String direccion;

    private int telefono;

    private String email;


    @OneToMany(mappedBy = "centro", cascade = CascadeType.ALL)
    private List<Transportes> transportes;

//    @OneToMany()
//    private List<User> usuarios;

    @OneToMany(mappedBy = "centro", cascade = CascadeType.ALL)
    private List<Admin> admins;

    public Centro() {
    }

    public Centro(String nombre, String direccion, int telefono, String email, List<Transportes> transportes, List<Admin> admins) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.transportes = transportes;
        this.admins = admins;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transportes> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<Transportes> transportes) {
        this.transportes = transportes;
    }

    public List<Admin> getAdmins() { return admins; }

    public void setAdmins(List<Admin> admins) { this.admins = admins; }
}
