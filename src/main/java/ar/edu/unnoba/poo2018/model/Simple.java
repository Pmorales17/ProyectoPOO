package ar.edu.unnoba.poo2018.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ACTIVIDAD_SIMPLE")
@DiscriminatorValue(value = "Simple")
@NamedQueries({
    @NamedQuery(name = "simple.allSimples", query = "SELECT s FROM Simple s")
    ,
    @NamedQuery(name = "impacto.getAllImpactos", query = "SELECT i FROM Impacto i")
})
public class Simple extends Actividad {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "Actividad_FK")
    private List<Impacto> impactos = new ArrayList<Impacto>();

    // Constructores.
    public Simple(String nombre, Date fechaInicio, Date fechaFin, String resolucion, String expediente, Convocatoria convocatoria, LineaEstrategica lineaEstrategica, Ambito ambito, List<Usuario> responsables) {
        super(nombre, fechaInicio, fechaFin, resolucion, expediente, convocatoria, lineaEstrategica, ambito, responsables);
        this.impactos = impactos;
    }

    public Simple() {
    }

    public void addImpacto(Impacto impacto) {
        this.impactos.add(impacto);
    }

    public void removeImpacto(Impacto impacto) {
        this.impactos.remove(impacto);
    }

    @Override
    public List<Impacto> getImpactos() {
        return impactos;
    }

    public void setImpactos(List<Impacto> impactos) {
        this.impactos = impactos;
    }
}
