package persistencias;
// Generated 3/05/2018 09:12:03 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivEstadodeudas generated by hbm2java
 */
public class CivEstadodeudas  implements java.io.Serializable {


     private BigDecimal estdeuId;
     private String estdeuDescripcion;
     private Date estdeuFechainicial;
     private Date estdeuFechafinal;
     private Set civDeudases = new HashSet(0);

    public CivEstadodeudas() {
    }

	
    public CivEstadodeudas(BigDecimal estdeuId) {
        this.estdeuId = estdeuId;
    }
    public CivEstadodeudas(BigDecimal estdeuId, String estdeuDescripcion, Date estdeuFechainicial, Date estdeuFechafinal, Set civDeudases) {
       this.estdeuId = estdeuId;
       this.estdeuDescripcion = estdeuDescripcion;
       this.estdeuFechainicial = estdeuFechainicial;
       this.estdeuFechafinal = estdeuFechafinal;
       this.civDeudases = civDeudases;
    }
   
    public BigDecimal getEstdeuId() {
        return this.estdeuId;
    }
    
    public void setEstdeuId(BigDecimal estdeuId) {
        this.estdeuId = estdeuId;
    }
    public String getEstdeuDescripcion() {
        return this.estdeuDescripcion;
    }
    
    public void setEstdeuDescripcion(String estdeuDescripcion) {
        this.estdeuDescripcion = estdeuDescripcion;
    }
    public Date getEstdeuFechainicial() {
        return this.estdeuFechainicial;
    }
    
    public void setEstdeuFechainicial(Date estdeuFechainicial) {
        this.estdeuFechainicial = estdeuFechainicial;
    }
    public Date getEstdeuFechafinal() {
        return this.estdeuFechafinal;
    }
    
    public void setEstdeuFechafinal(Date estdeuFechafinal) {
        this.estdeuFechafinal = estdeuFechafinal;
    }
    public Set getCivDeudases() {
        return this.civDeudases;
    }
    
    public void setCivDeudases(Set civDeudases) {
        this.civDeudases = civDeudases;
    }




}


