package persistencias;
// Generated 3/05/2018 09:12:03 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivEstadotablasparametrica generated by hbm2java
 */
public class CivEstadotablasparametrica  implements java.io.Serializable {


     private BigDecimal esttabId;
     private String esttabDescripcion;
     private Date esttabFechainicial;
     private Date esttabFechafinal;
     private Set civTablasparametricases = new HashSet(0);

    public CivEstadotablasparametrica() {
    }

	
    public CivEstadotablasparametrica(BigDecimal esttabId) {
        this.esttabId = esttabId;
    }
    public CivEstadotablasparametrica(BigDecimal esttabId, String esttabDescripcion, Date esttabFechainicial, Date esttabFechafinal, Set civTablasparametricases) {
       this.esttabId = esttabId;
       this.esttabDescripcion = esttabDescripcion;
       this.esttabFechainicial = esttabFechainicial;
       this.esttabFechafinal = esttabFechafinal;
       this.civTablasparametricases = civTablasparametricases;
    }
   
    public BigDecimal getEsttabId() {
        return this.esttabId;
    }
    
    public void setEsttabId(BigDecimal esttabId) {
        this.esttabId = esttabId;
    }
    public String getEsttabDescripcion() {
        return this.esttabDescripcion;
    }
    
    public void setEsttabDescripcion(String esttabDescripcion) {
        this.esttabDescripcion = esttabDescripcion;
    }
    public Date getEsttabFechainicial() {
        return this.esttabFechainicial;
    }
    
    public void setEsttabFechainicial(Date esttabFechainicial) {
        this.esttabFechainicial = esttabFechainicial;
    }
    public Date getEsttabFechafinal() {
        return this.esttabFechafinal;
    }
    
    public void setEsttabFechafinal(Date esttabFechafinal) {
        this.esttabFechafinal = esttabFechafinal;
    }
    public Set getCivTablasparametricases() {
        return this.civTablasparametricases;
    }
    
    public void setCivTablasparametricases(Set civTablasparametricases) {
        this.civTablasparametricases = civTablasparametricases;
    }




}


