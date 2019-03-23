package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Compuesta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class CompuestaDAO extends AbstractDAO<Compuesta> {

    public CompuestaDAO() {
        super(Compuesta.class);
    }

    public Compuesta getByNombre(String nombre) {
        Query query = em.createNamedQuery("compuesta.findbyNombre");
        query.setParameter("nombre", nombre);
        Compuesta compuesta = null;
        try {
            compuesta = (Compuesta) query.getSingleResult();
        } catch (NoResultException nre) {
        }
        return compuesta;
    }

    public List<Compuesta> getAllCompuestas() {
        Query query = em.createNamedQuery("compuesta.allCompuestas");
        return query.getResultList();
    }    
}