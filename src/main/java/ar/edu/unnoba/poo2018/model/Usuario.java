package ar.edu.unnoba.poo2018.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
@NamedQueries({
    @NamedQuery(name = "usuario.findbyEmailAndPassword",
            query = "SELECT u FROM Usuario u WHERE u.email = :email and u.password = :password")
    ,
    @NamedQuery(name = "usuario.allUsuarios",
            query = "SELECT u FROM Usuario u"),})
public class Usuario extends AbstractEntity {

    private String nombre;
    private String email;
    private String password;
    private boolean administrador;

    @ManyToMany(mappedBy = "responsables")
    private List<Actividad> actividades = new ArrayList<>();

    // Constructores.
    public Usuario(String nombre, String email, String password, boolean administrador) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.administrador = administrador;
    }

    public Usuario() {
    }

    // Getters y Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}
