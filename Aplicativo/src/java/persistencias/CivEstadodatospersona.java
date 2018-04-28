package persistencias;
// Generated 27/04/2018 03:42:45 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivEstadodatospersona generated by hbm2java
 */
public class CivEstadodatospersona  implements java.io.Serializable {


     private BigDecimal estdatId;
     private String estdatDescripcion;
     private Date estdatFechainicial;
     private Date estdatFechafinal;

    public CivEstadodatospersona() {
    }

	
    public CivEstadodatospersona(BigDecimal estdatId) {
        this.estdatId = estdatId;
    }
    public CivEstadodatospersona(BigDecimal estdatId, String estdatDescripcion, Date estdatFechainicial, Date estdatFechafinal) {
       this.estdatId = estdatId;
       this.estdatDescripcion = estdatDescripcion;
       this.estdatFechainicial = estdatFechainicial;
       this.estdatFechafinal = estdatFechafinal;
    }
   
    public BigDecimal getEstdatId() {
        return this.estdatId;
    }
    
    public void setEstdatId(BigDecimal estdatId) {
        this.estdatId = estdatId;
    }
    public String getEstdatDescripcion() {
        return this.estdatDescripcion;
    }
    
    public void setEstdatDescripcion(String estdatDescripcion) {
        this.estdatDescripcion = estdatDescripcion;
    }
    public Date getEstdatFechainicial() {
        return this.estdatFechainicial;
    }
    
    public void setEstdatFechainicial(Date estdatFechainicial) {
        this.estdatFechainicial = estdatFechainicial;
    }
    public Date getEstdatFechafinal() {
        return this.estdatFechafinal;
    }
    
    public void setEstdatFechafinal(Date estdatFechafinal) {
        this.estdatFechafinal = estdatFechafinal;
    }




}


