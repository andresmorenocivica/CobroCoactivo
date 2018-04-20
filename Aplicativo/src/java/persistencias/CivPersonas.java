package persistencias;
// Generated 17/04/2018 03:40:17 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivPersonas generated by hbm2java
 */
public class CivPersonas  implements java.io.Serializable {


     private BigDecimal perId;
     private CivTipodocumentos civTipodocumentos;
     private String perDocumento;
     private Date perFechanac;
     private String perSexo;
     private String perNombre1;
     private String perNombre2;
     private String perApellido1;
     private String perApellido2;
     private BigDecimal perLugarnacimiento;
     private Date perFechaexp;
     private BigDecimal perEstado;
     private Date perFechainicial;
     private Date perFechafinal;
     private Date perFechaproceso;
     private BigDecimal perLugarexpedicion;
     private Set civUsuarioses = new HashSet(0);
     private Set civDatospersonas = new HashSet(0);
     private Set civDeudases = new HashSet(0);

    public CivPersonas() {
    }

	
    public CivPersonas(BigDecimal perId, CivTipodocumentos civTipodocumentos, String perDocumento, String perNombre1, String perApellido1, BigDecimal perEstado) {
        this.perId = perId;
        this.civTipodocumentos = civTipodocumentos;
        this.perDocumento = perDocumento;
        this.perNombre1 = perNombre1;
        this.perApellido1 = perApellido1;
        this.perEstado = perEstado;
    }
    public CivPersonas(BigDecimal perId, CivTipodocumentos civTipodocumentos, String perDocumento, Date perFechanac, String perSexo, String perNombre1, String perNombre2, String perApellido1, String perApellido2, BigDecimal perLugarnacimiento, Date perFechaexp, BigDecimal perEstado, Date perFechainicial, Date perFechafinal, Date perFechaproceso, BigDecimal perLugarexpedicion, Set civUsuarioses, Set civDatospersonas, Set civDeudases) {
       this.perId = perId;
       this.civTipodocumentos = civTipodocumentos;
       this.perDocumento = perDocumento;
       this.perFechanac = perFechanac;
       this.perSexo = perSexo;
       this.perNombre1 = perNombre1;
       this.perNombre2 = perNombre2;
       this.perApellido1 = perApellido1;
       this.perApellido2 = perApellido2;
       this.perLugarnacimiento = perLugarnacimiento;
       this.perFechaexp = perFechaexp;
       this.perEstado = perEstado;
       this.perFechainicial = perFechainicial;
       this.perFechafinal = perFechafinal;
       this.perFechaproceso = perFechaproceso;
       this.perLugarexpedicion = perLugarexpedicion;
       this.civUsuarioses = civUsuarioses;
       this.civDatospersonas = civDatospersonas;
       this.civDeudases = civDeudases;
    }
   
    public BigDecimal getPerId() {
        return this.perId;
    }
    
    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }
    public CivTipodocumentos getCivTipodocumentos() {
        return this.civTipodocumentos;
    }
    
    public void setCivTipodocumentos(CivTipodocumentos civTipodocumentos) {
        this.civTipodocumentos = civTipodocumentos;
    }
    public String getPerDocumento() {
        return this.perDocumento;
    }
    
    public void setPerDocumento(String perDocumento) {
        this.perDocumento = perDocumento;
    }
    public Date getPerFechanac() {
        return this.perFechanac;
    }
    
    public void setPerFechanac(Date perFechanac) {
        this.perFechanac = perFechanac;
    }
    public String getPerSexo() {
        return this.perSexo;
    }
    
    public void setPerSexo(String perSexo) {
        this.perSexo = perSexo;
    }
    public String getPerNombre1() {
        return this.perNombre1;
    }
    
    public void setPerNombre1(String perNombre1) {
        this.perNombre1 = perNombre1;
    }
    public String getPerNombre2() {
        return this.perNombre2;
    }
    
    public void setPerNombre2(String perNombre2) {
        this.perNombre2 = perNombre2;
    }
    public String getPerApellido1() {
        return this.perApellido1;
    }
    
    public void setPerApellido1(String perApellido1) {
        this.perApellido1 = perApellido1;
    }
    public String getPerApellido2() {
        return this.perApellido2;
    }
    
    public void setPerApellido2(String perApellido2) {
        this.perApellido2 = perApellido2;
    }
    public BigDecimal getPerLugarnacimiento() {
        return this.perLugarnacimiento;
    }
    
    public void setPerLugarnacimiento(BigDecimal perLugarnacimiento) {
        this.perLugarnacimiento = perLugarnacimiento;
    }
    public Date getPerFechaexp() {
        return this.perFechaexp;
    }
    
    public void setPerFechaexp(Date perFechaexp) {
        this.perFechaexp = perFechaexp;
    }
    public BigDecimal getPerEstado() {
        return this.perEstado;
    }
    
    public void setPerEstado(BigDecimal perEstado) {
        this.perEstado = perEstado;
    }
    public Date getPerFechainicial() {
        return this.perFechainicial;
    }
    
    public void setPerFechainicial(Date perFechainicial) {
        this.perFechainicial = perFechainicial;
    }
    public Date getPerFechafinal() {
        return this.perFechafinal;
    }
    
    public void setPerFechafinal(Date perFechafinal) {
        this.perFechafinal = perFechafinal;
    }
    public Date getPerFechaproceso() {
        return this.perFechaproceso;
    }
    
    public void setPerFechaproceso(Date perFechaproceso) {
        this.perFechaproceso = perFechaproceso;
    }
    public BigDecimal getPerLugarexpedicion() {
        return this.perLugarexpedicion;
    }
    
    public void setPerLugarexpedicion(BigDecimal perLugarexpedicion) {
        this.perLugarexpedicion = perLugarexpedicion;
    }
    public Set getCivUsuarioses() {
        return this.civUsuarioses;
    }
    
    public void setCivUsuarioses(Set civUsuarioses) {
        this.civUsuarioses = civUsuarioses;
    }
    public Set getCivDatospersonas() {
        return this.civDatospersonas;
    }
    
    public void setCivDatospersonas(Set civDatospersonas) {
        this.civDatospersonas = civDatospersonas;
    }
    public Set getCivDeudases() {
        return this.civDeudases;
    }
    
    public void setCivDeudases(Set civDeudases) {
        this.civDeudases = civDeudases;
    }




}


