package persistencias;
// Generated 13/04/2018 11:20:37 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivDetalleDeudas generated by hbm2java
 */
public class CivDetalleDeudas  implements java.io.Serializable {


     private BigDecimal detdeuId;
     private CivDeudas civDeudas;
     private CivConceptos civConceptos;
     private String detdeuReferencia;
     private Date detdeuFecha;
     private BigDecimal detdeuEstado;
     private BigDecimal detdeuValor;

    public CivDetalleDeudas() {
    }

	
    public CivDetalleDeudas(BigDecimal detdeuId, CivDeudas civDeudas, CivConceptos civConceptos, Date detdeuFecha, BigDecimal detdeuEstado, BigDecimal detdeuValor) {
        this.detdeuId = detdeuId;
        this.civDeudas = civDeudas;
        this.civConceptos = civConceptos;
        this.detdeuFecha = detdeuFecha;
        this.detdeuEstado = detdeuEstado;
        this.detdeuValor = detdeuValor;
    }
    public CivDetalleDeudas(BigDecimal detdeuId, CivDeudas civDeudas, CivConceptos civConceptos, String detdeuReferencia, Date detdeuFecha, BigDecimal detdeuEstado, BigDecimal detdeuValor) {
       this.detdeuId = detdeuId;
       this.civDeudas = civDeudas;
       this.civConceptos = civConceptos;
       this.detdeuReferencia = detdeuReferencia;
       this.detdeuFecha = detdeuFecha;
       this.detdeuEstado = detdeuEstado;
       this.detdeuValor = detdeuValor;
    }
   
    public BigDecimal getDetdeuId() {
        return this.detdeuId;
    }
    
    public void setDetdeuId(BigDecimal detdeuId) {
        this.detdeuId = detdeuId;
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
    public BigDecimal getDetdeuEstado() {
        return this.detdeuEstado;
    }
    
    public void setDetdeuEstado(BigDecimal detdeuEstado) {
        this.detdeuEstado = detdeuEstado;
    }
    public BigDecimal getDetdeuValor() {
        return this.detdeuValor;
    }
    
    public void setDetdeuValor(BigDecimal detdeuValor) {
        this.detdeuValor = detdeuValor;
    }




}


