package persistencias;
// Generated 4/05/2018 09:28:55 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivEstadotipodatopersona generated by hbm2java
 */
public class CivEstadotipodatopersona  implements java.io.Serializable {


     private BigDecimal esttipdatId;
     private String esttipdatDescripcion;
     private Date esttipdatFechainicial;
     private Date esttipdatFechafinal;
     private Set civTipodatopersonas = new HashSet(0);

    public CivEstadotipodatopersona() {
    }

	
    public CivEstadotipodatopersona(BigDecimal esttipdatId) {
        this.esttipdatId = esttipdatId;
    }
    public CivEstadotipodatopersona(BigDecimal esttipdatId, String esttipdatDescripcion, Date esttipdatFechainicial, Date esttipdatFechafinal, Set civTipodatopersonas) {
       this.esttipdatId = esttipdatId;
       this.esttipdatDescripcion = esttipdatDescripcion;
       this.esttipdatFechainicial = esttipdatFechainicial;
       this.esttipdatFechafinal = esttipdatFechafinal;
       this.civTipodatopersonas = civTipodatopersonas;
    }
   
    public BigDecimal getEsttipdatId() {
        return this.esttipdatId;
    }
    
    public void setEsttipdatId(BigDecimal esttipdatId) {
        this.esttipdatId = esttipdatId;
    }
    public String getEsttipdatDescripcion() {
        return this.esttipdatDescripcion;
    }
    
    public void setEsttipdatDescripcion(String esttipdatDescripcion) {
        this.esttipdatDescripcion = esttipdatDescripcion;
    }
    public Date getEsttipdatFechainicial() {
        return this.esttipdatFechainicial;
    }
    
    public void setEsttipdatFechainicial(Date esttipdatFechainicial) {
        this.esttipdatFechainicial = esttipdatFechainicial;
    }
    public Date getEsttipdatFechafinal() {
        return this.esttipdatFechafinal;
    }
    
    public void setEsttipdatFechafinal(Date esttipdatFechafinal) {
        this.esttipdatFechafinal = esttipdatFechafinal;
    }
    public Set getCivTipodatopersonas() {
        return this.civTipodatopersonas;
    }
    
    public void setCivTipodatopersonas(Set civTipodatopersonas) {
        this.civTipodatopersonas = civTipodatopersonas;
    }




}


