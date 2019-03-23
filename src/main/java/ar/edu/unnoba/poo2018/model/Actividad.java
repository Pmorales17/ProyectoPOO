package ar.edu.unnoba.poo2018.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.*;

@Entity
@Table(name = "ACTIVIDADES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Actividad_Tipo", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
    @NamedQuery(name = "actividad.allActividades",
            query = "Select a From Actividad a order by a.nombre")
})
public abstract class Actividad extends AbstractEntity {

    private String nombre;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    private String resolucion;
    private String expediente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Convocatoria_FK")
    private Convocatoria convocatoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LineaEstrategica_FK")
    private LineaEstrategica lineaEstrategica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Ambito_FK")
    private Ambito ambito;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Responsables",
            joinColumns = @JoinColumn(name = "Actividad_ID"),
            inverseJoinColumns = @JoinColumn(name = "Usuario_ID")
    )
    private List<Usuario> responsables = new ArrayList<>();

    // Constructores.
    public Actividad(String nombre, Date fechaInicio, Date fechaFin, String resolucion, String expediente, Convocatoria convocatoria, LineaEstrategica lineaEstrategica, Ambito ambito, List<Usuario> responsables) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.resolucion = resolucion;
        this.expediente = expediente;
        this.convocatoria = convocatoria;
        this.lineaEstrategica = lineaEstrategica;
        this.ambito = ambito;
        this.responsables = responsables;
    }

    public Actividad() {
    }

    // Getters y Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public LineaEstrategica getLineaEstrategica() {
        return lineaEstrategica;
    }

    public void setLineaEstrategica(LineaEstrategica lineaEstrategica) {
        this.lineaEstrategica = lineaEstrategica;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;

    }

    public void addUsuario(Usuario usuario) {
        responsables.add(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        responsables.remove(usuario);
    }

    public List<Usuario> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Usuario> responsables) {
        this.responsables = responsables;
    }

    public abstract List<Impacto> getImpactos();

}
