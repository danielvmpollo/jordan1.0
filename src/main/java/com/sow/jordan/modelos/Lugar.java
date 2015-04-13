/*
 * Paquete que contiene los modelos del sistema Jordan
 */
package com.sow.jordan.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * Catalogo que muestra los lugares dentro de Ciudad Universitaria
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name="Lugar")
public class Lugar implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    private String nombre;

    /**
     * Método que regresa el id del lugar
     * @return un entero con la información
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que asigna un nuevo id
     * @param id El nuervo valor
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que regresa el nombre del lugar
     * @return Una cadena con la información
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que asiga un nuevo nombre a un lugar
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
