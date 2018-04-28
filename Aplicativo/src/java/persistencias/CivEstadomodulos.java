package persistencias;
// Generated 27/04/2018 03:42:45 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivEstadomodulos generated by hbm2java
 */
public class CivEstadomodulos  implements java.io.Serializable {


     private BigDecimal estmodId;
     private String estmodDescripcion;
     private Date estmodFechainicial;
     private Date estmodFechafinal;

    public CivEstadomodulos() {
    }

	
    public CivEstadomodulos(BigDecimal estmodId) {
        this.estmodId = estmodId;
    }
    public CivEstadomodulos(BigDecimal estmodId, String estmodDescripcion, Date estmodFechainicial, Date estmodFechafinal) {
       this.estmodId = estmodId;
       this.estmodDescripcion = estmodDescripcion;
       this.estmodFechainicial = estmodFechainicial;
       this.estmodFechafinal = estmodFechafinal;
    }
   
    public BigDecimal getEstmodId() {
        return this.estmodId;
    }
    
    public void setEstmodId(BigDecimal estmodId) {
        this.estmodId = estmodId;
    }
    public String getEstmodDescripcion() {
        return this.estmodDescripcion;
    }
    
    public void setEstmodDescripcion(String estmodDescripcion) {
        this.estmodDescripcion = estmodDescripcion;
    }
    public Date getEstmodFechainicial() {
        return this.estmodFechainicial;
    }
    
    public void setEstmodFechainicial(Date estmodFechainicial) {
        this.estmodFechainicial = estmodFechainicial;
    }
    public Date getEstmodFechafinal() {
        return this.estmodFechafinal;
    }
    
    public void setEstmodFechafinal(Date estmodFechafinal) {
        this.estmodFechafinal = estmodFechafinal;
    }




}


