package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.dao.LineaEstrategicaDAO;
import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LineaBacking {

    private String nombre;
    private LineaEstrategica lineaEstrategica;
    private List<LineaEstrategica> lineasEstrategicas;

    @EJB
    private LineaEstrategicaDAO lineaEstrategicaDAO;

    @PostConstruct
    public void init() {
        lineaEstrategica = new LineaEstrategica();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LineaEstrategica getLineaEstrategica() {
        return lineaEstrategica;
    }

    public void setLineaEstrategica(LineaEstrategica lineaEstrategica) {
        this.lineaEstrategica = lineaEstrategica;
    }

    public List<LineaEstrategica> getAllLineasEstrategicas() {
        lineasEstrategicas = lineaEstrategicaDAO.getAllLineasEstrategicas();
        return lineasEstrategicas;
    }

    public String create() {
        try {
            lineaEstrategicaDAO.create(lineaEstrategica);
            return "/lineas/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            lineaEstrategicaDAO.update(lineaEstrategica);
            return "/lineas/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(LineaEstrategica lineaEstrategica) {
        lineaEstrategicaDAO.delete(lineaEstrategica);
    }
}
