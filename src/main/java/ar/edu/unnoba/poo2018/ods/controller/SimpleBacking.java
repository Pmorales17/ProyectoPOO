package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.dao.ObjetivoDAO;
import ar.edu.unnoba.poo2018.dao.SimpleDAO;
import ar.edu.unnoba.poo2018.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;
import ar.edu.unnoba.poo2018.model.Simple;
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
public class SimpleBacking implements Serializable {

    private Simple simple;
    private Impacto impacto;
    private Usuario usuario;
    private List<Simple> simples;
    private List<Objetivo> objetivos;
    private List<Usuario> usuarios;

    @EJB
    private SimpleDAO simpleDAO;

    @EJB
    private ObjetivoDAO objetivoDAO;

    @EJB
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
        this.simple = new Simple();
        this.impacto = new Impacto();
    }

    public List<Usuario> getAllUsuarios() {
        usuarios = usuarioDAO.getAllUsuarios();
        return usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Simple> getAllSimples() {
        simples = simpleDAO.getAllSimples();
        return simples;
    }

    public Simple getSimple() {
        return simple;
    }

    public void setSimple(Simple simple) {
        this.simple = simple;
    }

    public List<Objetivo> getAllObjetivos() {
        objetivos = objetivoDAO.getAllObjetivos();
        return objetivos;
    }

    public Impacto getImpacto() {
        return impacto;
    }

    public void setImpacto(Impacto impacto) {
        this.impacto = impacto;
    }

    public void addImpacto() {
        if (this.simple.getImpactos() == null) {
            this.simple.setImpactos(new ArrayList<>());
        }
        this.simple.addImpacto(impacto);
        impacto = new Impacto();
    }

    public void removeImpacto(Impacto impacto) {
        this.simple.getImpactos().remove(impacto);
    }

    public void addUsuario() {
        if (this.simple.getResponsables() == null) {
            this.simple.setResponsables(new ArrayList<>());
        }
        this.simple.getResponsables().add(usuario);
        usuario = new Usuario();
    }

    public void removeUsuario(Usuario usuario) {
        this.simple.getResponsables().remove(usuario);
    }

    public String create() {
        try {
            simpleDAO.create(this.getSimple());
            return "/actividades/simples/index?faces-redirect=true";
        } catch (EJBException e) {
            return null;
        }
    }

    public String update() {
        try {
            simpleDAO.update(simple);
            return "/actividades/simples/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Simple simple) {
        simpleDAO.delete(simple);
    }
}
