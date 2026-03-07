package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;
import java.util.ArrayList;

@Entity
public class Rutas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRuta;

    private String nombre;

    private ArrayList<LocalTime> horarioLlegada;


    private ArrayList<LocalTime> horarioSalida;

    private boolean estado;

    public Rutas() {
    }

    public Rutas(String nombre, ArrayList<LocalTime> horarioLlegada, ArrayList<LocalTime> horarioSalida, boolean estado) {
        this.nombre = nombre;
        this.horarioLlegada = horarioLlegada;
        this.horarioSalida = horarioSalida;
        this.estado = estado;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<LocalTime> getHorarioLlegada() {
        return horarioLlegada;
    }

    public void setHorarioLlegada(ArrayList<LocalTime> horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public ArrayList<LocalTime> getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(ArrayList<LocalTime> horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
