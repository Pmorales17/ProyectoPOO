package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.dao.ConvocatoriaDAO;
import ar.edu.unnoba.poo2018.model.Convocatoria;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConvocatoriaBacking {

    private String nombre;    
    private Convocatoria convocatoria;
    private List<Convocatoria> convocatorias;    

    @EJB
    private ConvocatoriaDAO convocatoriaDAO;

    @PostConstruct
    public void init() {
        convocatoria = new Convocatoria();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public List<Convocatoria> getAllConvocatorias() {
        convocatorias = convocatoriaDAO.getAllConvocatorias();
        return convocatorias;
    }

    public String create() {
        try {
            convocatoriaDAO.create(convocatoria);
            return "/convocatorias/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            convocatoriaDAO.update(convocatoria);
            return "/convocatorias/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Convocatoria convocatoria) {
        convocatoriaDAO.delete(convocatoria);
    }
}
