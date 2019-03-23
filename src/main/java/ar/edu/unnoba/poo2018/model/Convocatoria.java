package ar.edu.unnoba.poo2018.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONVOCATORIA")
@NamedQueries({
    @NamedQuery(name = "convocatoria.allConvocatorias", query = "SELECT c FROM Convocatoria c"),})
public class Convocatoria extends AbstractEntity {

    private String nombre;

    @OneToMany(mappedBy = "convocatoria")
    private List<Actividad> actividades;

    // Constructores.
    public Convocatoria(String nombre) {
        this.nombre = nombre;
    }

    public Convocatoria() {
    }

    // Getters y Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}
