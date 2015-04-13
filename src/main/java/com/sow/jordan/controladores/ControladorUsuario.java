/*
 * Paquete que contiene los controladores del sistema Jordan
 */
package com.sow.jordan.controladores;

import com.sow.jordan.modelos.Usuario;
import com.sow.jordan.servicios.ServicioUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Clase que ...
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Controller("controladorUsuario") //Indica que la clase es un controlador
@Scope("session") 
public class ControladorUsuario implements Serializable{
    
    @Autowired
    private ServicioUsuario servicioUsuario;
    
    private Usuario usuario;
    
    private List<Usuario> usuarios;

    @PostConstruct //Indica que se ejecutara despues de la inyeccion de dependencias
    public void inicia() {
        usuarios = servicioUsuario.cargarUsuarios();
    }
    
    public void guardarUsuario(){
        this.servicioUsuario.guardarUsuario(usuario);
        usuarios = servicioUsuario.cargarUsuarios();
        this.usuario = new Usuario();
    }
    
    public void eliminarUsuario(Usuario usuario){
        this.servicioUsuario.eliminarUsuario(usuario);
        usuarios = servicioUsuario.cargarUsuarios();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
