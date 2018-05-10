/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bo.GestionMovimientosBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.DetalleProcesoJuridico;
import model.Deudas;
import model.Movimientos;
import model.Personas;
import model.ProcesosJuridicos;
import model.TipoDocumentos;
import utility.Log_Handler;

/**
 *
 * @author jvergara
 */
public class BeanGestionMovimientos {

    private GestionMovimientosBO gestionMovimientosBO;
    private BeanLogin loginBO;
    private List<ProcesosJuridicos> listaProcesoJuridisco = new ArrayList<>();
    private ProcesosJuridicos procesosJuridicos;
    private int index;
    private boolean checkGeneral;
    private boolean renderBtnGuardar;
    private boolean renderTabla = false;

    private List<Movimientos> listaMovimientos;
    private Deudas deudas;
    private String nombreFaseBotonGuardar;

//comentario para deuda
    private List<Deudas> listaDeudas = new ArrayList<>();
    private int tipoBusqueda;
    private Personas personaConsulta;
    private String referenciaDeuda;
    private List<TipoDocumentos> listTipoDocumentos = new ArrayList<>();

    @PostConstruct
    public void cargarDatos() {
        try {

            getGestionMovimientosBO().cargarListaProceso(this);
            setRenderBtnGuardar(true);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void cargarMovimientoDeuda() {
        try {
            getGestionMovimientosBO().cargarMovimientoDeuda(this);

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void consultaMovimiento(Deudas deuda) {
        try {
            setDeudas(deuda);
            getGestionMovimientosBO().consultaMovimiento(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void movimientoDeudaCambiarFase() {
        try {
            getGestionMovimientosBO().movimientoDeudaCambiarFase(this);

        } catch (Exception e) {

            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void establecerListaDeudas(int index, List<Deudas> deudas) {
        try {
            getProcesosJuridicos().getDetalleProcesoJuridico().get(index).setListaDeudas(deudas);
            setIndex(index);
            setNombreFaseBotonGuardar(getProcesosJuridicos().getDetalleProcesoJuridico().get(index).getNombre());
//            if (index == getProcesosJuridicos().getDetalleProcesoJuridico().size() - 1) {
//                setRenderBtnGuardar(false);
//            } else {
//                setRenderBtnGuardar(true);
//            }

        } catch (Exception e) {

            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }

    }

    public void seleccionarTodosCombox() {
        try {
            if (checkGeneral) {
                for (int i = 0; i < getProcesosJuridicos().getDetalleProcesoJuridico().get(getIndex()).getListaDeudas().size(); i++) {
                    getProcesosJuridicos().getDetalleProcesoJuridico().get(getIndex()).getListaDeudas().get(i).setSelecionado(true);
                }

            } else {
                for (int i = 0; i < getProcesosJuridicos().getDetalleProcesoJuridico().get(getIndex()).getListaDeudas().size(); i++) {
                    getProcesosJuridicos().getDetalleProcesoJuridico().get(getIndex()).getListaDeudas().get(i).setSelecionado(false);
                }

            }

        } catch (Exception e) {

            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    /**
     * @return the gestionMovimientosBO
     */
    public GestionMovimientosBO getGestionMovimientosBO() {
        return gestionMovimientosBO;
    }

    /**
     * @param gestionMovimientosBO the gestionMovimientosBO to set
     */
    public void setGestionMovimientosBO(GestionMovimientosBO gestionMovimientosBO) {
        this.gestionMovimientosBO = gestionMovimientosBO;
    }

    /**
     * @return the loginBO
     */
    public BeanLogin getLoginBO() {
        return loginBO;
    }

    /**
     * @param loginBO the loginBO to set
     */
    public void setLoginBO(BeanLogin loginBO) {
        this.loginBO = loginBO;
    }

    /**
     * @return the listaProcesoJuridisco
     */
    public List<ProcesosJuridicos> getListaProcesoJuridisco() {
        return listaProcesoJuridisco;
    }

    /**
     * @param listaProcesoJuridisco the listaProcesoJuridisco to set
     */
    public void setListaProcesoJuridisco(List<ProcesosJuridicos> listaProcesoJuridisco) {
        this.listaProcesoJuridisco = listaProcesoJuridisco;
    }

    public ProcesosJuridicos getProcesosJuridicos() {
        return procesosJuridicos;
    }

    /**
     * @param procesosJuridicos the procesosJuridicos to set
     */
    public void setProcesosJuridicos(ProcesosJuridicos procesosJuridicos) {
        this.procesosJuridicos = procesosJuridicos;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the checkGeneral
     */
    public boolean isCheckGeneral() {
        return checkGeneral;
    }

    /**
     * @param checkGeneral the checkGeneral to set
     */
    public void setCheckGeneral(boolean checkGeneral) {
        this.checkGeneral = checkGeneral;
    }

    /**
     * @return the renderBtnGuardar
     */
    public boolean isRenderBtnGuardar() {
        return renderBtnGuardar;
    }

    /**
     * @param renderBtnGuardar the renderBtnGuardar to set
     */
    public void setRenderBtnGuardar(boolean renderBtnGuardar) {
        this.renderBtnGuardar = renderBtnGuardar;
    }

    /**
     * @return the renderTabla
     */
    public boolean isRenderTabla() {
        return renderTabla;
    }

    /**
     * @param renderTabla the renderTabla to set
     */
    public void setRenderTabla(boolean renderTabla) {
        this.renderTabla = renderTabla;
    }

    /**
     * @return the listaMovimientos
     */
    public List<Movimientos> getListaMovimientos() {
        return listaMovimientos;
    }

    /**
     * @param listaMovimientos the listaMovimientos to set
     */
    public void setListaMovimientos(List<Movimientos> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    /**
     * @return the deudas
     */
    public Deudas getDeudas() {
        return deudas;
    }

    /**
     * @param deudas the deudas to set
     */
    public void setDeudas(Deudas deudas) {
        this.deudas = deudas;
    }

    /**
     * @return the nombreFaseBotonGuardar
     */
    public String getNombreFaseBotonGuardar() {
        return nombreFaseBotonGuardar;
    }

    /**
     * @param nombreFaseBotonGuardar the nombreFaseBotonGuardar to set
     */
    public void setNombreFaseBotonGuardar(String nombreFaseBotonGuardar) {
        this.nombreFaseBotonGuardar = nombreFaseBotonGuardar;
    }

    /**
     * @return the listaDeudas
     */
    public List<Deudas> getListaDeudas() {
        return listaDeudas;
    }

    /**
     * @param listaDeudas the listaDeudas to set
     */
    public void setListaDeudas(List<Deudas> listaDeudas) {
        this.listaDeudas = listaDeudas;
    }

    /**
     * @return the tipoBusqueda
     */
    public int getTipoBusqueda() {
        return tipoBusqueda;
    }

    /**
     * @param tipoBusqueda the tipoBusqueda to set
     */
    public void setTipoBusqueda(int tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    /**
     * @return the personaConsulta
     */
    public Personas getPersonaConsulta() {
        return personaConsulta;
    }

    /**
     * @param personaConsulta the personaConsulta to set
     */
    public void setPersonaConsulta(Personas personaConsulta) {
        this.personaConsulta = personaConsulta;
    }

    /**
     * @return the referenciaDeuda
     */
    public String getReferenciaDeuda() {
        return referenciaDeuda;
    }

    /**
     * @param referenciaDeuda the referenciaDeuda to set
     */
    public void setReferenciaDeuda(String referenciaDeuda) {
        this.referenciaDeuda = referenciaDeuda;
    }

    /**
     * @return the listTipoDocumentos
     */
    public List<TipoDocumentos> getListTipoDocumentos() {
        return listTipoDocumentos;
    }

    /**
     * @param listTipoDocumentos the listTipoDocumentos to set
     */
    public void setListTipoDocumentos(List<TipoDocumentos> listTipoDocumentos) {
        this.listTipoDocumentos = listTipoDocumentos;
    }

}
