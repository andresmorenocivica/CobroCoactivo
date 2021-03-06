package persistencias;
// Generated 7/05/2018 09:33:50 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivEstadotiporecursos generated by hbm2java
 */
public class CivEstadotiporecursos  implements java.io.Serializable {


     private BigDecimal esttiprecId;
     private String esttiprecDescripcion;
     private Date esttiprecFechainicial;
     private Date esttiprecFechafinal;
     private Set civTiporecursoses = new HashSet(0);

    public CivEstadotiporecursos() {
    }

	
    public CivEstadotiporecursos(BigDecimal esttiprecId) {
        this.esttiprecId = esttiprecId;
    }
    public CivEstadotiporecursos(BigDecimal esttiprecId, String esttiprecDescripcion, Date esttiprecFechainicial, Date esttiprecFechafinal, Set civTiporecursoses) {
       this.esttiprecId = esttiprecId;
       this.esttiprecDescripcion = esttiprecDescripcion;
       this.esttiprecFechainicial = esttiprecFechainicial;
       this.esttiprecFechafinal = esttiprecFechafinal;
       this.civTiporecursoses = civTiporecursoses;
    }
   
    public BigDecimal getEsttiprecId() {
        return this.esttiprecId;
    }
    
    public void setEsttiprecId(BigDecimal esttiprecId) {
        this.esttiprecId = esttiprecId;
    }
    public String getEsttiprecDescripcion() {
        return this.esttiprecDescripcion;
    }
    
    public void setEsttiprecDescripcion(String esttiprecDescripcion) {
        this.esttiprecDescripcion = esttiprecDescripcion;
    }
    public Date getEsttiprecFechainicial() {
        return this.esttiprecFechainicial;
    }
    
    public void setEsttiprecFechainicial(Date esttiprecFechainicial) {
        this.esttiprecFechainicial = esttiprecFechainicial;
    }
    public Date getEsttiprecFechafinal() {
        return this.esttiprecFechafinal;
    }
    
    public void setEsttiprecFechafinal(Date esttiprecFechafinal) {
        this.esttiprecFechafinal = esttiprecFechafinal;
    }
    public Set getCivTiporecursoses() {
        return this.civTiporecursoses;
    }
    
    public void setCivTiporecursoses(Set civTiporecursoses) {
        this.civTiporecursoses = civTiporecursoses;
    }




}


