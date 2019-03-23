package ar.edu.unnoba.poo2018.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AMBITOS")
@NamedQuery(name = "ambito.allAmbitos", query = "SELECT a FROM Ambito a")

public class Ambito extends AbstractEntity {

    private String nombre;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ambito")
    private List<Actividad> actividades;

    // Constructores.
    public Ambito(String nombre) {
        this.nombre = nombre;
    }

    public Ambito() {
    }

    // Getters y Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
