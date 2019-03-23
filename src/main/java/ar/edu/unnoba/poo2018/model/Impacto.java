package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "IMPACTO")
@NamedQueries({
    @NamedQuery(name = "impacto.allImpactos", query = "SELECT i FROM Impacto i")
    ,
    @NamedQuery(name = "impacto.getAllObjetivos", query = "SELECT o FROM Objetivo o"),})
public class Impacto extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "Actividad_FK")
    private Simple simple;

    @ManyToOne
    @JoinColumn(name = "Objetivo_FK")
    private Objetivo objetivo;

    private int peso;

    // Constructores.
    public Impacto(int peso, Objetivo objetivo) {
        this.peso = peso;
        this.objetivo = objetivo;
    }

    public Impacto() {
    }

    // Getters y Setters.
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Simple getSimple() {
        return simple;
    }

    public void setSimple(Simple simple) {
        this.simple = simple;
    }
}
