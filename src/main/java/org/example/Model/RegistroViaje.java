package org.example.Model;

import jakarta.persistence.*;
import org.example.Model.Usuarios.Alumno;

import java.time.LocalDateTime;

@Entity
public class RegistroViaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegistro;

    @ManyToOne
    @JoinColumn(name = "idAlumno", referencedColumnName = "id_usuario")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idTransporte")
    private Transportes transporte;

    @ManyToOne
    @JoinColumn(name = "idParada")
    private Paradas parada;

    private LocalDateTime fechaHora;

    private boolean activo; // true = está en el transporte ahora mismo

    public RegistroViaje() {
    }

    public RegistroViaje(Alumno alumno, Transportes transporte, Paradas parada, LocalDateTime fechaHora, boolean activo) {
        this.alumno = alumno;
        this.transporte = transporte;
        this.parada = parada;
        this.fechaHora = fechaHora;
        this.activo = activo;
    }


    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Transportes getTransporte() {
        return transporte;
    }

    public void setTransporte(Transportes transporte) {
        this.transporte = transporte;
    }

    public Paradas getParada() {
        return parada;
    }

    public void setParada(Paradas parada) {
        this.parada = parada;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
