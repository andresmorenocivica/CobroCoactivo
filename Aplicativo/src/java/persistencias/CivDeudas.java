package persistencias;
// Generated 7/05/2018 09:33:50 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivDeudas generated by hbm2java
 */
public class CivDeudas  implements java.io.Serializable {


     private BigDecimal deuId;
     private CivUsuarios civUsuarios;
     private CivTipodeuda civTipodeuda;
     private CivProcesosjuridicos civProcesosjuridicos;
     private CivPersonas civPersonas;
     private CivEstadodeudas civEstadodeudas;
     private Date deuFecha;
     private String deuReferencia;
     private BigDecimal deuValor;
     private BigDecimal deuSaldo;
     private Date deuFechadeuda;
     private Set civDetalleDeudases = new HashSet(0);

    public CivDeudas() {
    }

	
    public CivDeudas(BigDecimal deuId, CivUsuarios civUsuarios, CivTipodeuda civTipodeuda, CivProcesosjuridicos civProcesosjuridicos, CivPersonas civPersonas, CivEstadodeudas civEstadodeudas, Date deuFecha, BigDecimal deuValor, BigDecimal deuSaldo, Date deuFechadeuda) {
        this.deuId = deuId;
        this.civUsuarios = civUsuarios;
        this.civTipodeuda = civTipodeuda;
        this.civProcesosjuridicos = civProcesosjuridicos;
        this.civPersonas = civPersonas;
        this.civEstadodeudas = civEstadodeudas;
        this.deuFecha = deuFecha;
        this.deuValor = deuValor;
        this.deuSaldo = deuSaldo;
        this.deuFechadeuda = deuFechadeuda;
    }
    public CivDeudas(BigDecimal deuId, CivUsuarios civUsuarios, CivTipodeuda civTipodeuda, CivProcesosjuridicos civProcesosjuridicos, CivPersonas civPersonas, CivEstadodeudas civEstadodeudas, Date deuFecha, String deuReferencia, BigDecimal deuValor, BigDecimal deuSaldo, Date deuFechadeuda, Set civDetalleDeudases) {
       this.deuId = deuId;
       this.civUsuarios = civUsuarios;
       this.civTipodeuda = civTipodeuda;
       this.civProcesosjuridicos = civProcesosjuridicos;
       this.civPersonas = civPersonas;
       this.civEstadodeudas = civEstadodeudas;
       this.deuFecha = deuFecha;
       this.deuReferencia = deuReferencia;
       this.deuValor = deuValor;
       this.deuSaldo = deuSaldo;
       this.deuFechadeuda = deuFechadeuda;
       this.civDetalleDeudases = civDetalleDeudases;
    }
   
    public BigDecimal getDeuId() {
        return this.deuId;
    }
    
    public void setDeuId(BigDecimal deuId) {
        this.deuId = deuId;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public CivTipodeuda getCivTipodeuda() {
        return this.civTipodeuda;
    }
    
    public void setCivTipodeuda(CivTipodeuda civTipodeuda) {
        this.civTipodeuda = civTipodeuda;
    }
    public CivProcesosjuridicos getCivProcesosjuridicos() {
        return this.civProcesosjuridicos;
    }
    
    public void setCivProcesosjuridicos(CivProcesosjuridicos civProcesosjuridicos) {
        this.civProcesosjuridicos = civProcesosjuridicos;
    }
    public CivPersonas getCivPersonas() {
        return this.civPersonas;
    }
    
    public void setCivPersonas(CivPersonas civPersonas) {
        this.civPersonas = civPersonas;
    }
    public CivEstadodeudas getCivEstadodeudas() {
        return this.civEstadodeudas;
    }
    
    public void setCivEstadodeudas(CivEstadodeudas civEstadodeudas) {
        this.civEstadodeudas = civEstadodeudas;
    }
    public Date getDeuFecha() {
        return this.deuFecha;
    }
    
    public void setDeuFecha(Date deuFecha) {
        this.deuFecha = deuFecha;
    }
    public String getDeuReferencia() {
        return this.deuReferencia;
    }
    
    public void setDeuReferencia(String deuReferencia) {
        this.deuReferencia = deuReferencia;
    }
    public BigDecimal getDeuValor() {
        return this.deuValor;
    }
    
    public void setDeuValor(BigDecimal deuValor) {
        this.deuValor = deuValor;
    }
    public BigDecimal getDeuSaldo() {
        return this.deuSaldo;
    }
    
    public void setDeuSaldo(BigDecimal deuSaldo) {
        this.deuSaldo = deuSaldo;
    }
    public Date getDeuFechadeuda() {
        return this.deuFechadeuda;
    }
    
    public void setDeuFechadeuda(Date deuFechadeuda) {
        this.deuFechadeuda = deuFechadeuda;
    }
    public Set getCivDetalleDeudases() {
        return this.civDetalleDeudases;
    }
    
    public void setCivDetalleDeudases(Set civDetalleDeudases) {
        this.civDetalleDeudases = civDetalleDeudases;
    }




}


