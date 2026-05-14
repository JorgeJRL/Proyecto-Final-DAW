package org.example.Model;

import jakarta.persistence.*;
import org.example.Model.Usuarios.Admin;

import java.time.LocalDateTime;

@Entity
public class Avisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAviso;

    private String mensaje;

    private int gravedad;

    private TipoAviso tipo;

    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Rutas ruta;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id_usuario")
    private Admin admin;

    public Avisos() {
    }

    public Avisos(String mensaje, int gravedad, LocalDateTime fechaHora, TipoAviso tipo, Rutas ruta, Admin admin) {
        this.mensaje = mensaje;
        this.gravedad = gravedad;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
        this.ruta = ruta;
        this.admin = admin;
    }

    public int getIdAviso() {
        return idAviso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public TipoAviso getTipo() {
        return tipo;
    }

    public void setTipo(TipoAviso tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Rutas getRuta() {
        return ruta;
    }

    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
