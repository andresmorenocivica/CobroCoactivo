package persistencias;
// Generated 3/05/2018 09:12:03 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivEstadodatospersona generated by hbm2java
 */
public class CivEstadodatospersona  implements java.io.Serializable {


     private BigDecimal estdatperId;
     private String estdatperDescripcion;
     private Date estdatperFechainicial;
     private Date estdatperFechafinal;
     private Set civDatospersonas = new HashSet(0);

    public CivEstadodatospersona() {
    }

	
    public CivEstadodatospersona(BigDecimal estdatperId) {
        this.estdatperId = estdatperId;
    }
    public CivEstadodatospersona(BigDecimal estdatperId, String estdatperDescripcion, Date estdatperFechainicial, Date estdatperFechafinal, Set civDatospersonas) {
       this.estdatperId = estdatperId;
       this.estdatperDescripcion = estdatperDescripcion;
       this.estdatperFechainicial = estdatperFechainicial;
       this.estdatperFechafinal = estdatperFechafinal;
       this.civDatospersonas = civDatospersonas;
    }
   
    public BigDecimal getEstdatperId() {
        return this.estdatperId;
    }
    
    public void setEstdatperId(BigDecimal estdatperId) {
        this.estdatperId = estdatperId;
    }
    public String getEstdatperDescripcion() {
        return this.estdatperDescripcion;
    }
    
    public void setEstdatperDescripcion(String estdatperDescripcion) {
        this.estdatperDescripcion = estdatperDescripcion;
    }
    public Date getEstdatperFechainicial() {
        return this.estdatperFechainicial;
    }
    
    public void setEstdatperFechainicial(Date estdatperFechainicial) {
        this.estdatperFechainicial = estdatperFechainicial;
    }
    public Date getEstdatperFechafinal() {
        return this.estdatperFechafinal;
    }
    
    public void setEstdatperFechafinal(Date estdatperFechafinal) {
        this.estdatperFechafinal = estdatperFechafinal;
    }
    public Set getCivDatospersonas() {
        return this.civDatospersonas;
    }
    
    public void setCivDatospersonas(Set civDatospersonas) {
        this.civDatospersonas = civDatospersonas;
    }




}


