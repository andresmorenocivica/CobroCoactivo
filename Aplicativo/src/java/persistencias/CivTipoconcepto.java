package persistencias;
// Generated 7/05/2018 09:33:50 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivTipoconcepto generated by hbm2java
 */
public class CivTipoconcepto  implements java.io.Serializable {


     private BigDecimal tipconId;
     private CivEstadotipoconcepto civEstadotipoconcepto;
     private String tipconDescripcion;
     private Date tipconFechainicial;
     private Date tipconFechafinal;
     private String tipconNombrecorto;
     private BigDecimal tipconCodigo;
     private Set civConceptoses = new HashSet(0);

    public CivTipoconcepto() {
    }

	
    public CivTipoconcepto(BigDecimal tipconId) {
        this.tipconId = tipconId;
    }
    public CivTipoconcepto(BigDecimal tipconId, CivEstadotipoconcepto civEstadotipoconcepto, String tipconDescripcion, Date tipconFechainicial, Date tipconFechafinal, String tipconNombrecorto, BigDecimal tipconCodigo, Set civConceptoses) {
       this.tipconId = tipconId;
       this.civEstadotipoconcepto = civEstadotipoconcepto;
       this.tipconDescripcion = tipconDescripcion;
       this.tipconFechainicial = tipconFechainicial;
       this.tipconFechafinal = tipconFechafinal;
       this.tipconNombrecorto = tipconNombrecorto;
       this.tipconCodigo = tipconCodigo;
       this.civConceptoses = civConceptoses;
    }
   
    public BigDecimal getTipconId() {
        return this.tipconId;
    }
    
    public void setTipconId(BigDecimal tipconId) {
        this.tipconId = tipconId;
    }
    public CivEstadotipoconcepto getCivEstadotipoconcepto() {
        return this.civEstadotipoconcepto;
    }
    
    public void setCivEstadotipoconcepto(CivEstadotipoconcepto civEstadotipoconcepto) {
        this.civEstadotipoconcepto = civEstadotipoconcepto;
    }
    public String getTipconDescripcion() {
        return this.tipconDescripcion;
    }
    
    public void setTipconDescripcion(String tipconDescripcion) {
        this.tipconDescripcion = tipconDescripcion;
    }
    public Date getTipconFechainicial() {
        return this.tipconFechainicial;
    }
    
    public void setTipconFechainicial(Date tipconFechainicial) {
        this.tipconFechainicial = tipconFechainicial;
    }
    public Date getTipconFechafinal() {
        return this.tipconFechafinal;
    }
    
    public void setTipconFechafinal(Date tipconFechafinal) {
        this.tipconFechafinal = tipconFechafinal;
    }
    public String getTipconNombrecorto() {
        return this.tipconNombrecorto;
    }
    
    public void setTipconNombrecorto(String tipconNombrecorto) {
        this.tipconNombrecorto = tipconNombrecorto;
    }
    public BigDecimal getTipconCodigo() {
        return this.tipconCodigo;
    }
    
    public void setTipconCodigo(BigDecimal tipconCodigo) {
        this.tipconCodigo = tipconCodigo;
    }
    public Set getCivConceptoses() {
        return this.civConceptoses;
    }
    
    public void setCivConceptoses(Set civConceptoses) {
        this.civConceptoses = civConceptoses;
    }




}


