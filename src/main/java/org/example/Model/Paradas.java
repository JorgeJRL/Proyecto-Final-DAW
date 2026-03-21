package org.example.Model;

import jakarta.persistence.*;

@Entity
public class Paradas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParada;

    private String nombreParada;

    private double  latitud;

    private double  longitud;

    private int orden;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Rutas ruta;


    public Paradas() {
    }

    public Paradas(String nombreParada, double  latitud, double  longitud, int orden, Rutas ruta) {
        this.nombreParada = nombreParada;
        this.latitud = latitud;
        this.longitud = longitud;
        this.orden = orden;
        this.ruta = ruta;
    }

    public int getIdParada() {
        return idParada;
    }

    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }

    public String getNombreParada() {
        return nombreParada;
    }

    public void setNombreParada(String nombreParada) {
        this.nombreParada = nombreParada;
    }

    public double  getLatitud() {
        return latitud;
    }

    public void setLatitud(double  latitud) {
        this.latitud = latitud;
    }

    public double  getLongitud() {
        return longitud;
    }

    public void setLongitud(double  longitud) {
        this.longitud = longitud;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Rutas getRuta() {
        return ruta;
    }

    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }


}
