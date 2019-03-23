package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class LineaEstrategicaDAO extends AbstractDAO<LineaEstrategica> {

    public LineaEstrategicaDAO() {
        super(LineaEstrategica.class);
    }
    
    public List<LineaEstrategica> getAllLineasEstrategicas() {
        Query query = em.createNamedQuery("linea.allLineas");
        return query.getResultList();
    }
}
