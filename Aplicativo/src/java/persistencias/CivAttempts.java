package persistencias;
// Generated 30/04/2018 08:39:48 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivAttempts generated by hbm2java
 */
public class CivAttempts  implements java.io.Serializable {


     private BigDecimal ttpId;
     private CivUsuarios civUsuarios;
     private long ttpIntentos;
     private Date ttpUltimoIntento;

    public CivAttempts() {
    }

    public CivAttempts(BigDecimal ttpId, CivUsuarios civUsuarios, long ttpIntentos, Date ttpUltimoIntento) {
       this.ttpId = ttpId;
       this.civUsuarios = civUsuarios;
       this.ttpIntentos = ttpIntentos;
       this.ttpUltimoIntento = ttpUltimoIntento;
    }
   
    public BigDecimal getTtpId() {
        return this.ttpId;
    }
    
    public void setTtpId(BigDecimal ttpId) {
        this.ttpId = ttpId;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public long getTtpIntentos() {
        return this.ttpIntentos;
    }
    
    public void setTtpIntentos(long ttpIntentos) {
        this.ttpIntentos = ttpIntentos;
    }
    public Date getTtpUltimoIntento() {
        return this.ttpUltimoIntento;
    }
    
    public void setTtpUltimoIntento(Date ttpUltimoIntento) {
        this.ttpUltimoIntento = ttpUltimoIntento;
    }




}


