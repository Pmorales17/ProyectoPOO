package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Ambito;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class AmbitoDAO extends AbstractDAO<Ambito> {

    public AmbitoDAO() {
        super(Ambito.class);
    }

    public Ambito getByNombre(String nombre) {
        Query query = em.createNamedQuery("ambito.findbyNombre");
        query.setParameter("nombre", nombre);
        Ambito ambito = null;
        try {
            ambito = (Ambito) query.getSingleResult();
        } catch (NoResultException nre) {
        }
        return ambito;
    }

    public List<Ambito> getAllAmbitos() {
        Query query = em.createNamedQuery("ambito.allAmbitos");
        return query.getResultList();
    }
}
