package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.dao.ImpactoDAO;
import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ImpactoBacking {

    private Impacto impacto;
    private List<Impacto> impactos;
    private Objetivo objetivo;
    private List<Objetivo> objetivos;
    private ObjetivoBacking objetivoBacking;

    @EJB
    private ImpactoDAO impactoDAO;

    @PostConstruct
    public void init() {
        impacto = new Impacto();
    }

    public Impacto getImpacto() {
        return impacto;
    }

    public void setImpacto(Impacto impacto) {
        this.impacto = impacto;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public void setObjetivos(List<Objetivo> objetivos) {
        this.objetivos = objetivoBacking.getAllObjetivos();
    }

    public List<Impacto> getAllImpactos() {
        impactos = impactoDAO.getAllImpactos();
        return impactos;
    }

    public void setAmbitos(List<Impacto> impactos) {
        this.impactos = impactos;
    }

    public void addObjetivo(Objetivo objetivo) {
        objetivos.add(objetivo);
    }

    public boolean removeObjetivo(Objetivo objetivo) {
        return objetivos.remove(objetivo);
    }

    public String create() {
        try {
            impactoDAO.create(this.getImpacto());
            return "/impactos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            impactoDAO.update(impacto);
            return "/impactos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Impacto impacto) {
        impactoDAO.delete(impacto);
    }
}
