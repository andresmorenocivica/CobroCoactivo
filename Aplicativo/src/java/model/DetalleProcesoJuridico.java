/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DetalleProcesoJuridico {
    private long id;
    private long idProcesoJuridico;
    private int tipo;
    private int diaInicial;
    private int diaFinal;
    private long idReporte;
    private int estado;
    private long idUsuario;
    private boolean direccion;
    private Date fechainicial;
    private Date fechaFinal;
    private String nombre;
    private List<Deudas> listaDeudas = new ArrayList<>();

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
     * @return the idProcesoJuridico
     */
    public long getIdProcesoJuridico() {
        return idProcesoJuridico;
    }

    /**
     * @param idProcesoJuridico the idProcesoJuridico to set
     */
    public void setIdProcesoJuridico(long idProcesoJuridico) {
        this.idProcesoJuridico = idProcesoJuridico;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the diaInicial
     */
    public int getDiaInicial() {
        return diaInicial;
    }

    /**
     * @param diaInicial the diaInicial to set
     */
    public void setDiaInicial(int diaInicial) {
        this.diaInicial = diaInicial;
    }

    /**
     * @return the diaFinal
     */
    public int getDiaFinal() {
        return diaFinal;
    }

    /**
     * @param diaFinal the diaFinal to set
     */
    public void setDiaFinal(int diaFinal) {
        this.diaFinal = diaFinal;
    }

    /**
     * @return the idReporte
     */
    public long getIdReporte() {
        return idReporte;
    }

    /**
     * @param idReporte the idReporte to set
     */
    public void setIdReporte(long idReporte) {
        this.idReporte = idReporte;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the idUsuario
     */
    public long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the direccion
     */
    public boolean isDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(boolean direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the fechainicial
     */
    public Date getFechainicial() {
        return fechainicial;
    }

    /**
     * @param fechainicial the fechainicial to set
     */
    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
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
     * @return the listaDeudas
     */
    public List<Deudas> getListaDeudas() {
        return listaDeudas;
    }

    /**
     * @param listaDeudas the listaDeudas to set
     */
    public void setListaDeudas(List<Deudas> listaDeudas) {
        this.listaDeudas = listaDeudas;
    }

    
}
