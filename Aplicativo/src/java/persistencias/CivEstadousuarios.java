package persistencias;
// Generated 30/04/2018 08:39:48 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivEstadousuarios generated by hbm2java
 */
public class CivEstadousuarios  implements java.io.Serializable {


     private BigDecimal estusuId;
     private String estusuDescripcion;
     private Date estusuFechainicial;
     private Date estusuFechafinal;
     private Set civUsuarioses = new HashSet(0);

    public CivEstadousuarios() {
    }

	
    public CivEstadousuarios(BigDecimal estusuId) {
        this.estusuId = estusuId;
    }
    public CivEstadousuarios(BigDecimal estusuId, String estusuDescripcion, Date estusuFechainicial, Date estusuFechafinal, Set civUsuarioses) {
       this.estusuId = estusuId;
       this.estusuDescripcion = estusuDescripcion;
       this.estusuFechainicial = estusuFechainicial;
       this.estusuFechafinal = estusuFechafinal;
       this.civUsuarioses = civUsuarioses;
    }
   
    public BigDecimal getEstusuId() {
        return this.estusuId;
    }
    
    public void setEstusuId(BigDecimal estusuId) {
        this.estusuId = estusuId;
    }
    public String getEstusuDescripcion() {
        return this.estusuDescripcion;
    }
    
    public void setEstusuDescripcion(String estusuDescripcion) {
        this.estusuDescripcion = estusuDescripcion;
    }
    public Date getEstusuFechainicial() {
        return this.estusuFechainicial;
    }
    
    public void setEstusuFechainicial(Date estusuFechainicial) {
        this.estusuFechainicial = estusuFechainicial;
    }
    public Date getEstusuFechafinal() {
        return this.estusuFechafinal;
    }
    
    public void setEstusuFechafinal(Date estusuFechafinal) {
        this.estusuFechafinal = estusuFechafinal;
    }
    public Set getCivUsuarioses() {
        return this.civUsuarioses;
    }
    
    public void setCivUsuarioses(Set civUsuarioses) {
        this.civUsuarioses = civUsuarioses;
    }




}


