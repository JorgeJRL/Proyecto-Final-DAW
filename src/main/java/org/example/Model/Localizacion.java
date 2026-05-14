package org.example.Model;

import jakarta.persistence.*;
import org.example.Model.Usuarios.Alumno;

import java.time.LocalDateTime;

@Entity
public class Localizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSeguimiento;

    private double latitud;

    private double Longitud;

    private LocalDateTime fechaHora;


    @ManyToOne
    @JoinColumn(name = "idTransporte")
    private Transportes transporte;

    public Localizacion() {
    }

    public Localizacion(double latitud, double longitud, LocalDateTime fechaHora, Transportes transporte) {
        this.latitud = latitud;
        Longitud = longitud;
        this.fechaHora = fechaHora;
        this.transporte = transporte;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double longitud) {
        Longitud = longitud;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Transportes getTransporte() {
        return transporte;
    }

    public void setTransporte(Transportes transporte) {
        this.transporte = transporte;
    }
}
