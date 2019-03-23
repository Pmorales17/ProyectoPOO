package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.dao.ActividadDAO;
import ar.edu.unnoba.poo2018.dao.CompuestaDAO;
import ar.edu.unnoba.poo2018.dao.SimpleDAO;
import ar.edu.unnoba.poo2018.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.model.Actividad;
import ar.edu.unnoba.poo2018.model.Compuesta;
import ar.edu.unnoba.poo2018.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CompuestaBacking implements Serializable {

    private Compuesta compuesta;
    private Actividad actividad;
    private Usuario usuario;

    @EJB
    private SimpleDAO simpleDAO;

    @EJB
    private ActividadDAO actividadDAO;

    @EJB
    private CompuestaDAO compuestaDAO;

    @EJB
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
        this.compuesta = new Compuesta();
        this.usuario = new Usuario();
        this.actividad = null;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.getAllUsuarios();
    }

    public Compuesta getCompuesta() {
        return compuesta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCompuesta(Compuesta compuesta) {
        this.compuesta = compuesta;
    }

    public List<Actividad> getAllActividades() {
        return actividadDAO.getAllActividades();
    }

    public List<Compuesta> getAllCompuestas() {
        return compuestaDAO.getAllCompuestas();
    }

    public void addUsuario() {
        if (this.compuesta.getResponsables() == null) {
            this.compuesta.setResponsables(new ArrayList<>());
        }
        this.compuesta.getResponsables().add(usuario);
        usuario = new Usuario();
    }

    public void removeUsuario(Usuario usuario) {
        this.compuesta.getResponsables().remove(usuario);
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public void addActividad() {
        if (this.compuesta.getActividades() == null) {
            this.compuesta.setActividades(new ArrayList<>());
        }
        this.compuesta.getActividades().add(actividad);
        actividad = null;
    }

    public void removeActividad(Actividad compuesta) {
        this.compuesta.getActividades().remove(compuesta);
    }

    public String create() {
        try {
            compuestaDAO.create(this.compuesta);
            return "/actividades/compuestas/index?faces-redirect=true";
        } catch (EJBException e) {
            return null;
        }
    }

    public String update() {
        try {
            compuestaDAO.update(compuesta);
            return "/actividades/compuestas/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Compuesta compuesta) {
        compuestaDAO.delete(compuesta);
    }

}
