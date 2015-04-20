/*
 * Paquete que contiene los modelos del sistema Jordan
 */
package com.sow.jordan.modelos;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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
    
    private byte[] contra;

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
        String llaveSimetrica = "holamundocruel12";
        SecretKeySpec key = new SecretKeySpec(llaveSimetrica.getBytes(), "AES");
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES");

            //Comienzo a encriptar
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] campoCifrado = cipher.doFinal(contrasena.getBytes());
            this.contra=campoCifrado;
            this.contrasena = new String (campoCifrado);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
        }
    }

    public byte[] getContra() {
        return contra;
    }

    public void setContra(byte[] contra) {
        this.contra = contra;
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
