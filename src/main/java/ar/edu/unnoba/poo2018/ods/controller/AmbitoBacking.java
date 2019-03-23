package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.dao.AmbitoDAO;
import ar.edu.unnoba.poo2018.model.Ambito;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AmbitoBacking {

    private String nombre;
    private Ambito ambito;
    private List<Ambito> ambitos;

    @EJB
    private AmbitoDAO ambitoDAO;

    @PostConstruct
    public void init() {
        ambito = new Ambito();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
    }

    public List<Ambito> getAllAmbitos() {
        ambitos = ambitoDAO.getAllAmbitos();
        return ambitos;
    }

    public void setAmbitos(List<Ambito> ambitos) {
        this.ambitos = ambitos;
    }

    public String create() {
        try {
            ambitoDAO.create(this.getAmbito());
            return "/ambitos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            ambitoDAO.update(ambito);
            return "/ambitos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Ambito ambito) {
        ambitoDAO.delete(ambito);
    }

}
