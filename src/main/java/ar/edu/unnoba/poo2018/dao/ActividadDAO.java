package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Actividad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class ActividadDAO extends AbstractDAO<Actividad> {

    public ActividadDAO() {
        super(Actividad.class);
    }

    public Actividad getByNombre(String nombre) {
        Query query = em.createNamedQuery("actividad.findbyNombre");
        query.setParameter("nombre", nombre);
        Actividad actividad = null;
        try {
            actividad = (Actividad) query.getSingleResult();
        } catch (NoResultException nre) {
        }
        return actividad;
    }

    public List<Actividad> getAllActividades() {
        Query query = em.createNamedQuery("actividad.allActividades");
        return query.getResultList();
    }
}
