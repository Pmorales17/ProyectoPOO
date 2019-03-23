package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.dao.ObjetivoDAO;
import ar.edu.unnoba.poo2018.model.Objetivo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ObjetivoBacking {

    private String nombre;
    private Objetivo objetivo;
    private List<Objetivo> objetivos;

    @EJB
    private ObjetivoDAO objetivoDAO;

    @PostConstruct
    public void init() {
        objetivo = new Objetivo();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public void setObjetivos(List<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }

    public List<Objetivo> getAllObjetivos() {
        objetivos = objetivoDAO.getAllObjetivos();
        return objetivos;
    }

    public String create() {
        try {
            objetivoDAO.create(this.getObjetivo());
            return "/objetivos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            objetivoDAO.update(objetivo);
            return "/objetivos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Objetivo objetivo) {
        objetivoDAO.delete(objetivo);
    }
}
