/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;


/**
 *
 * @author Admin
 */
public class Perfiles {
    private long id;
    @NotNull(message = "El Nombre del Perfil Es Requerido")
    private String nombre;
    private List<Recurso> listRecursos =  new ArrayList<>();

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the listRecursos
     */
    public List<Recurso> getListRecursos() {
        return listRecursos;
    }

    /**
     * @param listRecursos the listRecursos to set
     */
    public void setListRecursos(List<Recurso> listRecursos) {
        this.listRecursos = listRecursos;
    }

    
 
    
    
}
