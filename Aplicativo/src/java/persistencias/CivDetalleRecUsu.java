package persistencias;
// Generated 27/04/2018 03:42:45 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * CivDetalleRecUsu generated by hbm2java
 */
public class CivDetalleRecUsu  implements java.io.Serializable {


     private CivDetalleRecUsuId id;
     private CivUsuarios civUsuarios;
     private CivRecursos civRecursos;
     private CivDetalleRecursos civDetalleRecursos;
     private Boolean propiedadVisible;
     private Boolean propiedadEnabled;
     private Date fechaInicial;
     private Date fechaFin;

    public CivDetalleRecUsu() {
    }

	
    public CivDetalleRecUsu(CivDetalleRecUsuId id, CivUsuarios civUsuarios, CivRecursos civRecursos, CivDetalleRecursos civDetalleRecursos) {
        this.id = id;
        this.civUsuarios = civUsuarios;
        this.civRecursos = civRecursos;
        this.civDetalleRecursos = civDetalleRecursos;
    }
    public CivDetalleRecUsu(CivDetalleRecUsuId id, CivUsuarios civUsuarios, CivRecursos civRecursos, CivDetalleRecursos civDetalleRecursos, Boolean propiedadVisible, Boolean propiedadEnabled, Date fechaInicial, Date fechaFin) {
       this.id = id;
       this.civUsuarios = civUsuarios;
       this.civRecursos = civRecursos;
       this.civDetalleRecursos = civDetalleRecursos;
       this.propiedadVisible = propiedadVisible;
       this.propiedadEnabled = propiedadEnabled;
       this.fechaInicial = fechaInicial;
       this.fechaFin = fechaFin;
    }
   
    public CivDetalleRecUsuId getId() {
        return this.id;
    }
    
    public void setId(CivDetalleRecUsuId id) {
        this.id = id;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public CivRecursos getCivRecursos() {
        return this.civRecursos;
    }
    
    public void setCivRecursos(CivRecursos civRecursos) {
        this.civRecursos = civRecursos;
    }
    public CivDetalleRecursos getCivDetalleRecursos() {
        return this.civDetalleRecursos;
    }
    
    public void setCivDetalleRecursos(CivDetalleRecursos civDetalleRecursos) {
        this.civDetalleRecursos = civDetalleRecursos;
    }
    public Boolean getPropiedadVisible() {
        return this.propiedadVisible;
    }
    
    public void setPropiedadVisible(Boolean propiedadVisible) {
        this.propiedadVisible = propiedadVisible;
    }
    public Boolean getPropiedadEnabled() {
        return this.propiedadEnabled;
    }
    
    public void setPropiedadEnabled(Boolean propiedadEnabled) {
        this.propiedadEnabled = propiedadEnabled;
    }
    public Date getFechaInicial() {
        return this.fechaInicial;
    }
    
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }




}


