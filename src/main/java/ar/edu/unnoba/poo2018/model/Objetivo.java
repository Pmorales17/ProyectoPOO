package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "OBJETIVOS")
@NamedQueries({
    @NamedQuery(name = "objetivo.allObjetivos", query = "SELECT o FROM Objetivo o"),})
public class Objetivo extends AbstractEntity {

    private String nombre;

    // Constructores.
    public Objetivo(String nombre) {
        this.nombre = nombre;
    }

    public Objetivo() {
    }

    // Getters y Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
