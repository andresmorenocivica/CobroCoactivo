package persistencias;
// Generated 27/04/2018 03:42:45 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivEstadoplantilla generated by hbm2java
 */
public class CivEstadoplantilla  implements java.io.Serializable {


     private BigDecimal estplaId;
     private String estplaDescripcion;
     private Date estplaFechainicial;
     private Date estplaFechafinal;

    public CivEstadoplantilla() {
    }

	
    public CivEstadoplantilla(BigDecimal estplaId) {
        this.estplaId = estplaId;
    }
    public CivEstadoplantilla(BigDecimal estplaId, String estplaDescripcion, Date estplaFechainicial, Date estplaFechafinal) {
       this.estplaId = estplaId;
       this.estplaDescripcion = estplaDescripcion;
       this.estplaFechainicial = estplaFechainicial;
       this.estplaFechafinal = estplaFechafinal;
    }
   
    public BigDecimal getEstplaId() {
        return this.estplaId;
    }
    
    public void setEstplaId(BigDecimal estplaId) {
        this.estplaId = estplaId;
    }
    public String getEstplaDescripcion() {
        return this.estplaDescripcion;
    }
    
    public void setEstplaDescripcion(String estplaDescripcion) {
        this.estplaDescripcion = estplaDescripcion;
    }
    public Date getEstplaFechainicial() {
        return this.estplaFechainicial;
    }
    
    public void setEstplaFechainicial(Date estplaFechainicial) {
        this.estplaFechainicial = estplaFechainicial;
    }
    public Date getEstplaFechafinal() {
        return this.estplaFechafinal;
    }
    
    public void setEstplaFechafinal(Date estplaFechafinal) {
        this.estplaFechafinal = estplaFechafinal;
    }




}


