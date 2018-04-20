/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public class Parametros {

    private long id;
    
   @DecimalMax(value = "10000", message = "debe ingresar un numero ${value}")
    private int codigo;
   
   @DecimalMax(value = "10000", message = "debe ingresar un numero ${value}")
    private int estado;
   
   @NotNull(message = "la descripcion no puede estar vacia")
    private String nombre;
   
   @NotNull(message = "el nombre de la tabla no puede ser nulo")
   private String nombreTabla;
   
   @NotNull(message = "el campo nombre corto no puede ser nulo")
    @Size(min = 2 , max = 30 , message = "minimo dos caracteristica maximo 30")
    private String nombreCorto;
    
   @NotNull(message = "la fecha inicial no puede estar vacia")
    private Date fechaInicial;
    
    private Date FechaFinal;
    private int idTabla;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(Date FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public int getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(int idTabla) {
        this.idTabla = idTabla;
    }

}
