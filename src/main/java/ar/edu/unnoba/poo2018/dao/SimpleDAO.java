package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Simple;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class SimpleDAO extends AbstractDAO<Simple> {

    public SimpleDAO() {
        super(Simple.class);
    }

    public Simple getByNombre(String nombre) {
        Query query = em.createNamedQuery("simple.findbyNombre");
        query.setParameter("nombre", nombre);
        Simple simple = null;
        try {
            simple = (Simple) query.getSingleResult();
        } catch (NoResultException nre) {
        }
        return simple;
    }

    public List<Simple> getAllSimples() {
        Query query = em.createNamedQuery("simple.allSimples");
        return query.getResultList();
    }
}
