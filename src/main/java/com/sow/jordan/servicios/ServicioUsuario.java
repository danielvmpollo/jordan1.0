/*
 * Paquete que contiene ...
 */
package com.sow.jordan.servicios;

import com.sow.jordan.modelos.Usuario;
import java.util.List;

/**
 * 
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface ServicioUsuario {
    
    public void guardarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public List<Usuario> buscarPassword(String correo);
    
    List<Usuario> cargarUsuarios();
    
}
