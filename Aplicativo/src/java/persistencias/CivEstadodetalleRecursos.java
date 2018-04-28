package persistencias;
// Generated 27/04/2018 03:42:45 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivEstadodetalleRecursos generated by hbm2java
 */
public class CivEstadodetalleRecursos  implements java.io.Serializable {


     private BigDecimal estdetrecursosId;
     private String estdetrecursosDescripcion;
     private Date estdetrecursosFechainicial;
     private Date estdetrecursosFechafinal;

    public CivEstadodetalleRecursos() {
    }

	
    public CivEstadodetalleRecursos(BigDecimal estdetrecursosId) {
        this.estdetrecursosId = estdetrecursosId;
    }
    public CivEstadodetalleRecursos(BigDecimal estdetrecursosId, String estdetrecursosDescripcion, Date estdetrecursosFechainicial, Date estdetrecursosFechafinal) {
       this.estdetrecursosId = estdetrecursosId;
       this.estdetrecursosDescripcion = estdetrecursosDescripcion;
       this.estdetrecursosFechainicial = estdetrecursosFechainicial;
       this.estdetrecursosFechafinal = estdetrecursosFechafinal;
    }
   
    public BigDecimal getEstdetrecursosId() {
        return this.estdetrecursosId;
    }
    
    public void setEstdetrecursosId(BigDecimal estdetrecursosId) {
        this.estdetrecursosId = estdetrecursosId;
    }
    public String getEstdetrecursosDescripcion() {
        return this.estdetrecursosDescripcion;
    }
    
    public void setEstdetrecursosDescripcion(String estdetrecursosDescripcion) {
        this.estdetrecursosDescripcion = estdetrecursosDescripcion;
    }
    public Date getEstdetrecursosFechainicial() {
        return this.estdetrecursosFechainicial;
    }
    
    public void setEstdetrecursosFechainicial(Date estdetrecursosFechainicial) {
        this.estdetrecursosFechainicial = estdetrecursosFechainicial;
    }
    public Date getEstdetrecursosFechafinal() {
        return this.estdetrecursosFechafinal;
    }
    
    public void setEstdetrecursosFechafinal(Date estdetrecursosFechafinal) {
        this.estdetrecursosFechafinal = estdetrecursosFechafinal;
    }




}

