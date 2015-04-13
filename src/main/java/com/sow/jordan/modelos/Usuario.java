/*
 * Paquete que contiene los modelos del sistema Jordan
 */
package com.sow.jordan.modelos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    
    @Id
    private String usuario;
    
    @NotNull
    @Column(name = "contrasena")
    private String contrasena;
    
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    
    @NotNull
    @Column(name = "correo")
    private String correo;
    
    @NotNull
    @Column(name = "privilegio")
    private String privilegio = "USER";

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }
}
