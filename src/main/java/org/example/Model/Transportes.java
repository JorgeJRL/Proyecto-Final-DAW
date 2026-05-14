package org.example.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Transportes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransporte;

    private String matricula;

    private String tipo ;

    @ManyToOne
    @JoinColumn(name = "idCentro")
    private Centro centro;

    @OneToMany(mappedBy = "transporte", cascade = CascadeType.ALL)
    private List<Localizacion> localizacion;

    public Transportes() {
    }

    public Transportes(String matricula, String tipo) {
        this.matricula = matricula;
        this.tipo = tipo;
    }


    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
