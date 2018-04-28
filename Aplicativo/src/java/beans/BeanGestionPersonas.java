/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bo.GestionPersonasBO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Deudas;
import model.Personas;
import model.TipoDato;
import model.TipoDocumentos;
import utility.Log_Handler;

/**
 *
 * @author jvergara
 */
public class BeanGestionPersonas {

    private BeanLogin loginBO;
    private List<TipoDocumentos> listTipoDocumento;
    private List<Personas> listPersonas;
    private String numero;
    private String nombre;
    private Date fecha;
    private int idDocumentoSelecionado;
    private GestionPersonasBO gestionPersonasBO;
    private Deudas deudas;
    private List<TipoDato> datosPersona;
    private String encabezadoDetallePersona; //informacion detalle personas
    private Personas detallePersona;

    @PostConstruct
    public void init() {
        try {

            BeanRequest obj_ = (BeanRequest) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("requestBean");
            if (obj_ != null) {
                setDetallePersona(obj_.getPersonas());
                setEncabezadoDetallePersona(obj_.getRuta());
                getGestionPersonasBO().buscarDatosPersonas(this);
                gestionPersonasBO.buscarHistorialDeudasPersonas(this);
            }

//            setPersonas(new Personas());
            setListTipoDocumento(new ArrayList<>());
            setListPersonas(new ArrayList<>());
            getGestionPersonasBO().llenarDatos(this);
            

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }

    }

    public void consultarPorNumero() {
        try {
            getGestionPersonasBO().consultarPorNumero(this);

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void buscarDatosPersonas() {
        try {
           getGestionPersonasBO().buscarDatosPersonas(this);

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void editarPersona() {
        try {
            getDetallePersona().setEditable(false);
            getDetallePersona();
            getGestionPersonasBO().update(this);

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public BeanGestionPersonas() {
    }

    public List<TipoDocumentos> getListTipoDocumento() {
        return listTipoDocumento;
    }

    public void setListTipoDocumento(List<TipoDocumentos> listTipoDocumento) {
        this.listTipoDocumento = listTipoDocumento;
    }

    public List<Personas> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Personas> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdDocumentoSelecionado() {
        return idDocumentoSelecionado;
    }

    public void setIdDocumentoSelecionado(int idDocumentoSelecionado) {
        this.idDocumentoSelecionado = idDocumentoSelecionado;
    }

    public GestionPersonasBO getGestionPersonasBO() {
        return gestionPersonasBO;
    }

    public void setGestionPersonasBO(GestionPersonasBO gestionPersonasBO) {
        this.gestionPersonasBO = gestionPersonasBO;
    }

    public BeanLogin getLoginBO() {
        return loginBO;
    }

    public void setLoginBO(BeanLogin loginBO) {
        this.loginBO = loginBO;
    }

    public String getEncabezadoDetallePersona() {
        return encabezadoDetallePersona;
    }

    public void setEncabezadoDetallePersona(String encabezadoDetallePersona) {
        this.encabezadoDetallePersona = encabezadoDetallePersona;
    }

    public Personas getDetallePersona() {
        return detallePersona;
    }

    public void setDetallePersona(Personas detallePersona) {
        this.detallePersona = detallePersona;
    }

    public Deudas getDeudas() {
        return deudas;
    }

    public void setDeudas(Deudas deudas) {
        this.deudas = deudas;
    }

    public List<TipoDato> getDatosPersona() {
        return datosPersona;
    }

    public void setDatosPersona(List<TipoDato> datosPersona) {
        this.datosPersona = datosPersona;
    }

}
