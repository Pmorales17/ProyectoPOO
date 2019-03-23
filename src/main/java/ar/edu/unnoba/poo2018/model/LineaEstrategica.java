package ar.edu.unnoba.poo2018.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LINEAS")
@NamedQueries({
    @NamedQuery(name = "linea.allLineas", query = "SELECT l FROM LineaEstrategica l"),})
public class LineaEstrategica extends AbstractEntity {

    private String nombre;

    @OneToMany(mappedBy = "lineaEstrategica")
    private List<Actividad> actividades;

    // Constructores.
    public LineaEstrategica(String nombre) {
        this.nombre = nombre;
    }

    public LineaEstrategica() {
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
