package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.model.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SessionBacking {

    private String email;
    private String password;
    private Usuario usuario;

    @EJB
    private UsuarioDAO usuarioDAO;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String login() {
        usuario = null;
        usuario = usuarioDAO.login(email, password);
        if (usuario == null) {
            return "error?faces-redirect=true";
        }
        return "welcome?faces-redirect=true";
    }

    public String logout() {
        usuario = null;
        return "index?faces-redirect=true";
    }
}
