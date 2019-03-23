package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Usuario;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario login(String email, String password) {
        Query query = em.createNamedQuery("usuario.findbyEmailAndPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);
        Usuario usuario = null;
        try {
            usuario = (Usuario) query.getSingleResult();
        } catch (NoResultException nre) {}
        return usuario;
    }
    
   public Usuario getByMail(String mail) {
        Query query = em.createNamedQuery("usuario.findbyMail");
        query.setParameter("mail", mail);
        Usuario usuario = null;
        try {
            usuario = (Usuario) query.getSingleResult();
        } catch (NoResultException nre) {}
        return usuario;
    }    
    
    public List<Usuario> getAllUsuarios(){
        Query query = em.createNamedQuery("usuario.allUsuarios");
        return query.getResultList();
    }
}
