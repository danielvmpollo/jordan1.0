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
@Table(name="Menu")
public class Menu implements Serializable {
    
    /**
     * Variable que indica el id del menu, las etiquetas indican dicha variable
     * es el id y que se va a ir auto incrementando.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;    
    
    /**
     * Variable que almacena la categiria del menu, la etiqueta indica que no
     * puede ser nulo su valor.
     */
    @NotNull
    private String categoria;
    
    private Double precioMin;

    private Double precioMax;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private Local local;

    /**
     * Método que regresa el id del menu
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
     * Método que regresa la categoria del menu
     * @return Una cadena con la información
     */
    public String getCategoria() {
       return categoria;
    }

    /**
     * Método que asigna una nueva categoria
     * @param categoria La nueva categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    public Double getPrecioMin() {
        return precioMin;
    }

    public void setPrecioMin(Double precioMin) {
        this.precioMin = precioMin;
    }

    public Double getPrecioMax() {
        return precioMax;
    }

    public void setPrecioMax(Double precioMax) {
        this.precioMax = precioMax;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.categoria);
        hash = 67 * hash + Objects.hashCode(this.precioMin);
        hash = 67 * hash + Objects.hashCode(this.precioMax);
        return hash;
    }    
    
}