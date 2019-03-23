package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Convocatoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ConvocatoriaDAO extends AbstractDAO<Convocatoria> {

    public ConvocatoriaDAO() {
        super(Convocatoria.class);
    }

    public List<Convocatoria> getAllConvocatorias() {
        Query query = em.createNamedQuery("convocatoria.allConvocatorias");
        return query.getResultList();
    }

}
