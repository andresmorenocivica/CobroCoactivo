package persistencias;
// Generated 4/05/2018 09:28:55 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivEstadopersona generated by hbm2java
 */
public class CivEstadopersona  implements java.io.Serializable {


     private BigDecimal estperId;
     private String estperDescripcion;
     private Date estperFechainicial;
     private Date estperFechafinal;
     private Set civPersonases = new HashSet(0);

    public CivEstadopersona() {
    }

	
    public CivEstadopersona(BigDecimal estperId) {
        this.estperId = estperId;
    }
    public CivEstadopersona(BigDecimal estperId, String estperDescripcion, Date estperFechainicial, Date estperFechafinal, Set civPersonases) {
       this.estperId = estperId;
       this.estperDescripcion = estperDescripcion;
       this.estperFechainicial = estperFechainicial;
       this.estperFechafinal = estperFechafinal;
       this.civPersonases = civPersonases;
    }
   
    public BigDecimal getEstperId() {
        return this.estperId;
    }
    
    public void setEstperId(BigDecimal estperId) {
        this.estperId = estperId;
    }
    public String getEstperDescripcion() {
        return this.estperDescripcion;
    }
    
    public void setEstperDescripcion(String estperDescripcion) {
        this.estperDescripcion = estperDescripcion;
    }
    public Date getEstperFechainicial() {
        return this.estperFechainicial;
    }
    
    public void setEstperFechainicial(Date estperFechainicial) {
        this.estperFechainicial = estperFechainicial;
    }
    public Date getEstperFechafinal() {
        return this.estperFechafinal;
    }
    
    public void setEstperFechafinal(Date estperFechafinal) {
        this.estperFechafinal = estperFechafinal;
    }
    public Set getCivPersonases() {
        return this.civPersonases;
    }
    
    public void setCivPersonases(Set civPersonases) {
        this.civPersonases = civPersonases;
    }




}


