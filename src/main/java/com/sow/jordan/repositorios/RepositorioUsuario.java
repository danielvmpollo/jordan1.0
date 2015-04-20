/*
 * Paquete que contienje los repositorios del sistema Jordan
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface RepositorioUsuario extends CrudRepository<Usuario, String>{
    
    @Query("SELECT usuario FROM Usuario usuario")
    List<Usuario> cargarUsuarios();
    
    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.correo = ?")
    public List<Usuario> buscarPassword(String correo);
   
}
