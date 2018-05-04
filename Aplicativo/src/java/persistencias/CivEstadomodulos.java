package persistencias;
// Generated 4/05/2018 09:28:55 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivEstadomodulos generated by hbm2java
 */
public class CivEstadomodulos  implements java.io.Serializable {


     private BigDecimal estmodId;
     private String estmodDescripcion;
     private Date estmodFechainicial;
     private Date estmodFechafinal;
     private Set civModuloses = new HashSet(0);

    public CivEstadomodulos() {
    }

	
    public CivEstadomodulos(BigDecimal estmodId) {
        this.estmodId = estmodId;
    }
    public CivEstadomodulos(BigDecimal estmodId, String estmodDescripcion, Date estmodFechainicial, Date estmodFechafinal, Set civModuloses) {
       this.estmodId = estmodId;
       this.estmodDescripcion = estmodDescripcion;
       this.estmodFechainicial = estmodFechainicial;
       this.estmodFechafinal = estmodFechafinal;
       this.civModuloses = civModuloses;
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
    public Set getCivModuloses() {
        return this.civModuloses;
    }
    
    public void setCivModuloses(Set civModuloses) {
        this.civModuloses = civModuloses;
    }




}


