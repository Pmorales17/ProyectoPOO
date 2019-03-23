package ar.edu.unnoba.poo2018.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ACTIVIDAD_COMPUESTA")
@DiscriminatorValue(value = "Compuesta")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@NamedQueries({
    @NamedQuery(name = "compuesta.allCompuestas", query = "SELECT c FROM Compuesta c")
})
public class Compuesta extends Actividad {

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "Actividades_Relacionadas",
            joinColumns = @JoinColumn(name = "Actividad_Compuesta_ID"),
            inverseJoinColumns = @JoinColumn(name = "Actividad_ID")
    )
    private List<Actividad> actividades = new ArrayList<Actividad>();

    // Constructores.
    public Compuesta(String nombre, Date fechaInicio, Date fechaFin, String resolucion, String expediente, Convocatoria convocatoria, LineaEstrategica lineaEstrategica, Ambito ambito, List<Usuario> responsables) {
        super(nombre, fechaInicio, fechaFin, resolucion, expediente, convocatoria, lineaEstrategica, ambito, responsables);
    }

    public Compuesta() {

    }

    public void addActividad(Actividad a) {
        actividades.add(a);
    }

    public void removeActividad(Actividad a) {
        actividades.remove(a);
    }

    @Override
    public List<Impacto> getImpactos() {
        // Obtiene los impactos de todas las actividades. Por ser una actividad compuesta
        // el peso del impacto sera el promedio del peso del impacto de las actividades
        // que la componen para dicho objetivo.
        return null;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}
