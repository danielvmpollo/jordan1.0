/*
 * Paquete que contiene los controladores del sistema Jordan
 */
package com.sow.jordan.controladores;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import com.sow.jordan.modelos.Usuario;
import com.sow.jordan.servicios.ServicioUsuario;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

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
    
    @Autowired
    private JavaMailSenderImpl mailSender;
    
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
    
    public void enviarMail(){
        String llaveSimetrica = "holamundocruel12";

        SecretKeySpec key = new SecretKeySpec(llaveSimetrica.getBytes(), "AES");
        Cipher cipher;
        
        this.usuarios=servicioUsuario.buscarPassword(usuario.getCorreo());
            
        SimpleMailMessage mail=new SimpleMailMessage();
        if(this.usuarios.isEmpty()==false){
            for (Usuario u : this.usuarios) {
                try {
                    cipher = Cipher.getInstance("AES");
                    cipher.init(Cipher.DECRYPT_MODE, key);
                    byte[] datosDecifrados = cipher.doFinal(u.getContra());
                    String contrasenia = new String(datosDecifrados);
                    mail.setTo(u.getCorreo());
                    mail.setFrom("jordan.dantm@gmail.com");
                    mail.setSubject("JORDAN");
                    mail.setText("RECUPERACION DE CONTRASEÑA\n\n\n" + "Hola " + u.getNombre() + " tu contraseña es: " + contrasenia);
                    try {
                        mailSender.send(mail);
                        addMessage("Tu contraseña se ha enviado al correo que proporcionaste");
                    } catch (MailException ex) {
                        addMessage("No se pudo enviar el mensaje");
                    }
                } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
                    addMessage("No se pudo desencriptar");
                }
            }
        } else {
            addMessage("El correo que proporcionaste no existe en el registro");
        }
    }
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
