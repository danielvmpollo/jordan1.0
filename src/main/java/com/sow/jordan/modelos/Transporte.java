/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sow.jordan.modelos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Clase que servirá como un catalogo que muestra los lugares dentro de Ciudad
 * Universitaria
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name="Transporte")
public class Transporte implements Serializable {
    
    /**
     * Variable que indica el id del transporte, las etiquetas indican dicha variable
     * es el id y que se va a ir auto incrementando.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;    
    
    /**
     * Variable que almacena el tipo de transporte, la etiqueta indica que no
     * puede ser nulo su valor.
     */
    @NotNull
    private String tipo;
    
    /**
     * Variable que almacena la estación del tranporte, la etiqueta indica que no
     * puede ser nulo su valor.
     */
    @NotNull
    private String estacion;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private Local local;

    /**
     * Método que regresa el id del tranporte
     * @return un entero con la información
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que asigna un nuevo id
     * @param id El nuevo valor del id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que regresa el tipo de transporte
     * @return Una cadena con la información
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que asigna un nuevo tipo de transporte
     * @param tipo La nueva categoria
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.tipo);
        hash = 61 * hash + Objects.hashCode(this.estacion);
        return hash;
    }
    
}