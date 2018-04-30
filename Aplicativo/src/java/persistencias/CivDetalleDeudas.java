package persistencias;
// Generated 30/04/2018 08:39:48 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivDetalleDeudas generated by hbm2java
 */
public class CivDetalleDeudas  implements java.io.Serializable {


     private BigDecimal detdeuId;
     private CivEstadodetalleDeudas civEstadodetalleDeudas;
     private CivDeudas civDeudas;
     private CivConceptos civConceptos;
     private String detdeuReferencia;
     private Date detdeuFecha;
     private BigDecimal detdeuValor;

    public CivDetalleDeudas() {
    }

	
    public CivDetalleDeudas(BigDecimal detdeuId, CivEstadodetalleDeudas civEstadodetalleDeudas, CivDeudas civDeudas, CivConceptos civConceptos, Date detdeuFecha, BigDecimal detdeuValor) {
        this.detdeuId = detdeuId;
        this.civEstadodetalleDeudas = civEstadodetalleDeudas;
        this.civDeudas = civDeudas;
        this.civConceptos = civConceptos;
        this.detdeuFecha = detdeuFecha;
        this.detdeuValor = detdeuValor;
    }
    public CivDetalleDeudas(BigDecimal detdeuId, CivEstadodetalleDeudas civEstadodetalleDeudas, CivDeudas civDeudas, CivConceptos civConceptos, String detdeuReferencia, Date detdeuFecha, BigDecimal detdeuValor) {
       this.detdeuId = detdeuId;
       this.civEstadodetalleDeudas = civEstadodetalleDeudas;
       this.civDeudas = civDeudas;
       this.civConceptos = civConceptos;
       this.detdeuReferencia = detdeuReferencia;
       this.detdeuFecha = detdeuFecha;
       this.detdeuValor = detdeuValor;
    }
   
    public BigDecimal getDetdeuId() {
        return this.detdeuId;
    }
    
    public void setDetdeuId(BigDecimal detdeuId) {
        this.detdeuId = detdeuId;
    }
    public CivEstadodetalleDeudas getCivEstadodetalleDeudas() {
        return this.civEstadodetalleDeudas;
    }
    
    public void setCivEstadodetalleDeudas(CivEstadodetalleDeudas civEstadodetalleDeudas) {
        this.civEstadodetalleDeudas = civEstadodetalleDeudas;
    }
    public CivDeudas getCivDeudas() {
        return this.civDeudas;
    }
    
    public void setCivDeudas(CivDeudas civDeudas) {
        this.civDeudas = civDeudas;
    }
    public CivConceptos getCivConceptos() {
        return this.civConceptos;
    }
    
    public void setCivConceptos(CivConceptos civConceptos) {
        this.civConceptos = civConceptos;
    }
    public String getDetdeuReferencia() {
        return this.detdeuReferencia;
    }
    
    public void setDetdeuReferencia(String detdeuReferencia) {
        this.detdeuReferencia = detdeuReferencia;
    }
    public Date getDetdeuFecha() {
        return this.detdeuFecha;
    }
    
    public void setDetdeuFecha(Date detdeuFecha) {
        this.detdeuFecha = detdeuFecha;
    }
    public BigDecimal getDetdeuValor() {
        return this.detdeuValor;
    }
    
    public void setDetdeuValor(BigDecimal detdeuValor) {
        this.detdeuValor = detdeuValor;
    }




}


