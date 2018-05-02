/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author jvergara
 */
public class DatosPersona {
    
    private long id;
    private TipoDato tipoDatoPersona;
    private String Descricion;
    private EstadoPersona estadoPersona;
    private Date fechaInicial;
    private Date fechaFinal;
    private Personas personas;

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
     * @return the tipoDatoPersona
     */
    public TipoDato getTipoDatoPersona() {
        return tipoDatoPersona;
    }

    /**
     * @param tipoDatoPersona the tipoDatoPersona to set
     */
    public void setTipoDatoPersona(TipoDato tipoDatoPersona) {
        this.tipoDatoPersona = tipoDatoPersona;
    }

    /**
     * @return the Descricion
     */
    public String getDescricion() {
        return Descricion;
    }

    /**
     * @param Descricion the Descricion to set
     */
    public void setDescricion(String Descricion) {
        this.Descricion = Descricion;
    }

    /**
     * @return the fechaInicial
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return the fechaFinal
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return the personas
     */
    public Personas getPersonas() {
        return personas;
    }

    /**
     * @param personas the personas to set
     */
    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    /**
     * @return the estadoPersona
     */
    public EstadoPersona getEstadoPersona() {
        return estadoPersona;
    }

    /**
     * @param estadoPersona the estadoPersona to set
     */
    public void setEstadoPersona(EstadoPersona estadoPersona) {
        this.estadoPersona = estadoPersona;
    }
    
    
}
