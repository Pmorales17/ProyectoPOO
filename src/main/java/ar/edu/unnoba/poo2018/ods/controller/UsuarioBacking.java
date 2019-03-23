package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioBacking implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    @EJB
    private UsuarioDAO usuarioDAO;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getAllUsuarios() {
        usuarios = usuarioDAO.getAllUsuarios();
        return usuarios;
    }

    public String create() {
        try {
            usuarioDAO.create(this.getUsuario());
            return "/usuarios/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            usuarioDAO.update(usuario);
            return "/usuarios/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }
}
