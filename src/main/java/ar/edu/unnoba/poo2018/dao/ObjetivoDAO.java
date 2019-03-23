package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Objetivo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class ObjetivoDAO extends AbstractDAO<Objetivo> {

    public ObjetivoDAO() {
        super(Objetivo.class);
    }

    public Objetivo getByNombre(String nombre) {
        Query query = em.createNamedQuery("objetivo.findbyNombre");
        query.setParameter("nombre", nombre);
        Objetivo objetivo = null;
        try {
            objetivo = (Objetivo) query.getSingleResult();
        } catch (NoResultException nre) {}
        return objetivo;
    }
    
    public List<Objetivo> getAllObjetivos() {
        Query query = em.createNamedQuery("objetivo.allObjetivos");
        return query.getResultList();
    }
}
