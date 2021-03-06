package persistencias;
// Generated 7/05/2018 09:33:50 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivEstadoconceptos generated by hbm2java
 */
public class CivEstadoconceptos  implements java.io.Serializable {


     private BigDecimal estconId;
     private String estconDescripcion;
     private Date estconFechainicial;
     private Date estconFechafinal;
     private Set civConceptoses = new HashSet(0);

    public CivEstadoconceptos() {
    }

	
    public CivEstadoconceptos(BigDecimal estconId) {
        this.estconId = estconId;
    }
    public CivEstadoconceptos(BigDecimal estconId, String estconDescripcion, Date estconFechainicial, Date estconFechafinal, Set civConceptoses) {
       this.estconId = estconId;
       this.estconDescripcion = estconDescripcion;
       this.estconFechainicial = estconFechainicial;
       this.estconFechafinal = estconFechafinal;
       this.civConceptoses = civConceptoses;
    }
   
    public BigDecimal getEstconId() {
        return this.estconId;
    }
    
    public void setEstconId(BigDecimal estconId) {
        this.estconId = estconId;
    }
    public String getEstconDescripcion() {
        return this.estconDescripcion;
    }
    
    public void setEstconDescripcion(String estconDescripcion) {
        this.estconDescripcion = estconDescripcion;
    }
    public Date getEstconFechainicial() {
        return this.estconFechainicial;
    }
    
    public void setEstconFechainicial(Date estconFechainicial) {
        this.estconFechainicial = estconFechainicial;
    }
    public Date getEstconFechafinal() {
        return this.estconFechafinal;
    }
    
    public void setEstconFechafinal(Date estconFechafinal) {
        this.estconFechafinal = estconFechafinal;
    }
    public Set getCivConceptoses() {
        return this.civConceptoses;
    }
    
    public void setCivConceptoses(Set civConceptoses) {
        this.civConceptoses = civConceptoses;
    }




}


