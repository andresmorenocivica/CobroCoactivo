/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionParametros;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdbc.dao.ITEstadoTipoDocumento;
import jdbc.dao.ITLogin;
import jdbc.dao.ITTablasParametricas;
import jdbc.dao.ITTipoConceptos;
import jdbc.dao.ITTipoDeuda;
import jdbc.dao.ITTipoDocumento;
import jdbc.dao.ITTipoPersonas;
import model.Parametros;
import model.tablaEstadosParametricos;
import model.tablasParametricas;
import persistencias.CivEstadotablasparametrica;
import persistencias.CivTablasparametricas;
import persistencias.CivTipoconcepto;
import persistencias.CivTipodatopersona;
import persistencias.CivTipodeuda;
import persistencias.CivTipodocumentos;

/**
 *
 * @author Admin
 */
public class GestionParametrosImpBO implements GestionParametrosBO, Serializable {

    private ITLogin loginDAO;
    private ITTablasParametricas tablasParametricasDAO;
    private ITTipoDocumento tiposDocumentosDAO;
    private ITTipoConceptos tipoConceptosDAO;
    private ITTipoDeuda tipoDeudaDAO;
    private ITTipoPersonas tipoPersonasDAO;
    private ITEstadoTipoDocumento estadoTipoDocumentoDAO;

    @Override
    public void llenarDatos(BeanGestionParametros bean) throws Exception {
        bean.setListaTablasParametricas(new ArrayList<>());
        tablasParametricas tablaParameticasModel = new tablasParametricas();
        getLoginDAO();
        int registro = 0;
        List<CivTablasparametricas> list = getTablasParametricasDAO().listAll();
        for (CivTablasparametricas civTablasParametricas : list) {
            tablaParameticasModel = new tablasParametricas();
            tablaParameticasModel.setId(civTablasParametricas.getTabparId().intValue());
            tablaParameticasModel.setNombre(civTablasParametricas.getTabparNombre());
            tablaParameticasModel.setNombreTabla(civTablasParametricas.getTabparNombretabla());
            tablaParameticasModel.setEstado(civTablasParametricas.getCivEstadotablasparametrica().getEsttabId().intValue());
            tablaParameticasModel.setFechaInicial(civTablasParametricas.getTabparFechainicial());
            tablaParameticasModel.setFechaFinal(civTablasParametricas.getTabparFechafinal());
            bean.getListaTablasParametricas().add(tablaParameticasModel);
            
            switch (civTablasParametricas.getTabparNombretabla()) {
                case "CIV_TIPOSDOCUMENTOS":
                    List<CivTipodocumentos> listCivTipodocumentos = getTiposDocumentosDAO().listAll();
                    for (CivTipodocumentos civTipoDocumentos : listCivTipodocumentos) {
                        Parametros parametrosTipoDocumento = new Parametros();
                        parametrosTipoDocumento.setCodigo(civTipoDocumentos.getTipdocCodigo().intValue());
                        parametrosTipoDocumento.setEstado(civTipoDocumentos.getCivEstadotipodocumentos().getEsttipdocId().intValue());
                        parametrosTipoDocumento.setFechaFinal(civTipoDocumentos.getTipdocFechafinal());
                        parametrosTipoDocumento.setFechaInicial(civTipoDocumentos.getTipdocFechainicial());
                        parametrosTipoDocumento.setNombre(civTipoDocumentos.getTipdocNombre());
                        parametrosTipoDocumento.setNombreCorto(civTipoDocumentos.getTipdocNombrecorto());
                        parametrosTipoDocumento.setId(civTipoDocumentos.getTipdocId().longValue());
                        parametrosTipoDocumento.setNombreTabla(civTablasParametricas.getTabparNombretabla());
                        parametrosTipoDocumento.setIdTabla(civTablasParametricas.getTabparId().intValue());
                        bean.getListaTablasParametricas().get(registro).getListParametros().add(parametrosTipoDocumento);
                        cargarListaEstado(bean);

                    }
                    break;

                case "CIV_TIPOCONCEPTO":
                    List<CivTipoconcepto> listCivTipoconceptos = getTipoConceptosDAO().listAll();
                    for (CivTipoconcepto civTipoconcepto : listCivTipoconceptos) {
                        Parametros parametrosTipoDocumento = new Parametros();
                        parametrosTipoDocumento.setCodigo(civTipoconcepto.getTipconCodigo().intValue());
                        parametrosTipoDocumento.setEstado(civTipoconcepto.getCivEstadotipoconcepto().getEsttipconId().intValue());
                        parametrosTipoDocumento.setFechaFinal(civTipoconcepto.getTipconFechafinal());
                        parametrosTipoDocumento.setFechaInicial(civTipoconcepto.getTipconFechainicial());
                        parametrosTipoDocumento.setNombre(civTipoconcepto.getTipconDescripcion());
                        parametrosTipoDocumento.setNombreCorto(civTipoconcepto.getTipconNombrecorto());
                        parametrosTipoDocumento.setId(civTipoconcepto.getTipconId().longValue());
                        parametrosTipoDocumento.setNombreTabla(civTablasParametricas.getTabparNombretabla());
                        parametrosTipoDocumento.setIdTabla(civTablasParametricas.getTabparId().intValue());
                        bean.getListaTablasParametricas().get(registro).getListParametros().add(parametrosTipoDocumento);
                        cargarListaEstado(bean);
                    }
                    break;

                case "CIV_TIPODEUDA":
                    List<CivTipodeuda> listCivTipoDeuda = getTipoDeudaDAO().listAll();
                    for (CivTipodeuda civTipoDeuda : listCivTipoDeuda) {
                        Parametros parametrosTipoDeuda = new Parametros();
                        parametrosTipoDeuda.setCodigo(civTipoDeuda.getTipdeuCodigo().intValue());
                        parametrosTipoDeuda.setEstado(civTipoDeuda.getCivEstadotipodeuda().getEsttipdeuId().intValue());
                        parametrosTipoDeuda.setFechaFinal(civTipoDeuda.getTipdeuFechafinal());
                        parametrosTipoDeuda.setFechaInicial(civTipoDeuda.getTipdeuFechainicial());
                        parametrosTipoDeuda.setNombre(civTipoDeuda.getTipdeuDescripcion());
                        parametrosTipoDeuda.setNombreCorto(civTipoDeuda.getTipdeuNombrecorto());
                        parametrosTipoDeuda.setId(civTipoDeuda.getTipdeuId().longValue());
                        parametrosTipoDeuda.setNombreTabla(civTablasParametricas.getTabparNombretabla());
                        parametrosTipoDeuda.setIdTabla(civTablasParametricas.getTabparId().intValue());
                        bean.getListaTablasParametricas().get(registro).getListParametros().add(parametrosTipoDeuda);
                        cargarListaEstado(bean);
                    }
                    break;

                case "CIV_TIPODATOPERSONA":
                    List<CivTipodatopersona> listCivTipoDatosPersona = getTipoPersonasDAO().listAll();
                    for (CivTipodatopersona civTipoDatosPersona : listCivTipoDatosPersona) {
                        Parametros parametrosTipoDeuda = new Parametros();
                        parametrosTipoDeuda.setCodigo(civTipoDatosPersona.getTipdatperCodigo().intValue());
                        parametrosTipoDeuda.setEstado(civTipoDatosPersona.getCivEstadotipodatopersona().getEsttipdatId().intValue());
                        parametrosTipoDeuda.setFechaFinal(civTipoDatosPersona.getTipdatperFechafinal());
                        parametrosTipoDeuda.setFechaInicial(civTipoDatosPersona.getTipdatperFechainical());
                        parametrosTipoDeuda.setNombre(civTipoDatosPersona.getTipdatperDescripcion());
                        parametrosTipoDeuda.setNombreCorto(civTipoDatosPersona.getTipdatperNombrecorto());
                        parametrosTipoDeuda.setId(civTipoDatosPersona.getTipdatperId().longValue());
                        parametrosTipoDeuda.setNombreTabla(civTablasParametricas.getTabparNombretabla());
                        parametrosTipoDeuda.setIdTabla(civTablasParametricas.getTabparId().intValue());
                        bean.getListaTablasParametricas().get(registro).getListParametros().add(parametrosTipoDeuda);
                        cargarListaEstado(bean);
                    }
                    break;
                case "CIV_TIPORECURSOS":
                    break;
            }
            registro++;
        }

    }

    public void cargarListaEstado(BeanGestionParametros bean) throws Exception {
//        List<CivEstadotablasparametrica> civTablasparametricases = getTablasParametricasDAO().listAll();
//        for (CivTablasparametricas civTablasparametricase : civTablasparametricases) {
//            tablaEstadosParametricos taParametricas = new tablaEstadosParametricos();
//            taParametricas.setId(civTablasparametricase.getTabparId().longValue());
//            taParametricas.setNombre(civTablasparametricase.getTabparNombre());
//            bean.getListaEstadoTablaParametricas().add(taParametricas);
//        }
    }

    @Override
    public void eliminarRegistro(BeanGestionParametros bean) throws Exception {
        switch (bean.getRegistroParametro().getNombreTabla()) {
            case "CIV_TIPOSDOCUMENTOS":
                CivTipodocumentos civTipoDocumentos = new CivTipodocumentos();
                civTipoDocumentos.setTipdocId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoDocumentos.setTipdocCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                civTipoDocumentos.setCivEstadotipodocumentos(getEstadoTipoDocumentoDAO().consultarById(2));
                civTipoDocumentos.setTipdocFechainicial(bean.getRegistroParametro().getFechaInicial());
                civTipoDocumentos.setTipdocFechafinal(new Date());
                civTipoDocumentos.setTipdocNombre(bean.getRegistroParametro().getNombre());
                civTipoDocumentos.setTipdocNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTiposDocumentosDAO().update(civTipoDocumentos);
                break;

            case "CIV_TIPOCONCEPTO":
                CivTipoconcepto civTipoconcepto = new CivTipoconcepto();
                civTipoconcepto.setTipconId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoconcepto.setTipconCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoconcepto.setTipconEstado(BigDecimal.valueOf(2));
                civTipoconcepto.setTipconFechainicial(bean.getRegistroParametro().getFechaInicial());
                civTipoconcepto.setTipconFechafinal(new Date());
                civTipoconcepto.setTipconDescripcion(bean.getRegistroParametro().getNombre());
                civTipoconcepto.setTipconNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTipoConceptosDAO().update(civTipoconcepto);
                break;

            case "CIV_TIPODEUDA":
                CivTipodeuda civTipodeuda = new CivTipodeuda();
                civTipodeuda.setTipdeuId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipodeuda.setTipdeuCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipodeuda.setTipdeuEstado(BigDecimal.valueOf(2));
                civTipodeuda.setTipdeuFechainicial(bean.getRegistroParametro().getFechaInicial());
                civTipodeuda.setTipdeuFechafinal(new Date());
                civTipodeuda.setTipdeuDescripcion(bean.getRegistroParametro().getNombre());
                civTipodeuda.setTipdeuNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTipoDeudaDAO().update(civTipodeuda);
                break;

            case "CIV_TIPODATOPERSONA":
                CivTipodatopersona civTipoDatopersona = new CivTipodatopersona();
                civTipoDatopersona.setTipdatperId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoDatopersona.setTipdatperCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoDatopersona.setTipdatperEstado(BigDecimal.valueOf(2));
                civTipoDatopersona.setTipdatperFechainical(bean.getRegistroParametro().getFechaInicial());
                civTipoDatopersona.setTipdatperFechafinal(new Date());
                civTipoDatopersona.setTipdatperDescripcion(bean.getRegistroParametro().getNombre());
                civTipoDatopersona.setTipdatperNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTipoPersonasDAO().update(civTipoDatopersona);
                break;

        }

    }

    @Override
    public void update(BeanGestionParametros bean) throws Exception {
        switch (bean.getRegistroParametro().getNombreTabla()) {
            case "CIV_TIPOSDOCUMENTOS":
                CivTipodocumentos civTipoDocuementos = new CivTipodocumentos();
                civTipoDocuementos.setTipdocId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoDocuementos.setTipdocCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoDocuementos.setTipdocEstado(BigDecimal.valueOf(bean.getRegistroParametro().getEstado()));
                civTipoDocuementos.setTipdocFechainicial(bean.getRegistroParametro().getFechaInicial());
                civTipoDocuementos.setTipdocFechafinal(bean.getRegistroParametro().getFechaFinal());
                civTipoDocuementos.setTipdocNombre(bean.getRegistroParametro().getNombre());
                civTipoDocuementos.setTipdocNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTiposDocumentosDAO().update(civTipoDocuementos);
                break;
            case "CIV_TIPOCONCEPTO":
                CivTipoconcepto civTipoconcepto = new CivTipoconcepto();
                civTipoconcepto.setTipconId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoconcepto.setTipconCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoconcepto.setTipconEstado(BigDecimal.valueOf(bean.getRegistroParametro().getEstado()));
                civTipoconcepto.setTipconFechainicial(bean.getRegistroParametro().getFechaInicial());
                civTipoconcepto.setTipconFechafinal(bean.getRegistroParametro().getFechaFinal());
                civTipoconcepto.setTipconDescripcion(bean.getRegistroParametro().getNombre());
                civTipoconcepto.setTipconNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTipoConceptosDAO().update(civTipoconcepto);
                break;
            case "CIV_TIPODEUDA":
                CivTipodeuda civTipoDeuda = new CivTipodeuda();
                civTipoDeuda.setTipdeuId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoDeuda.setTipdeuCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoDeuda.setTipdeuEstado(BigDecimal.valueOf(bean.getRegistroParametro().getEstado()));
                civTipoDeuda.setTipdeuFechainicial(bean.getRegistroParametro().getFechaInicial());
                civTipoDeuda.setTipdeuFechafinal(bean.getRegistroParametro().getFechaFinal());
                civTipoDeuda.setTipdeuDescripcion(bean.getRegistroParametro().getNombre());
                civTipoDeuda.setTipdeuNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTipoDeudaDAO().update(civTipoDeuda);
                break;
            case "CIV_TIPODATOPERSONA":
                CivTipodatopersona civTipoDatoPersona = new CivTipodatopersona();
                civTipoDatoPersona.setTipdatperId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoDatoPersona.setTipdatperCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoDatoPersona.setTipdatperEstado(BigDecimal.valueOf(bean.getRegistroParametro().getEstado()));
                civTipoDatoPersona.setTipdatperFechainical(bean.getRegistroParametro().getFechaInicial());
                civTipoDatoPersona.setTipdatperFechafinal(bean.getRegistroParametro().getFechaFinal());
                civTipoDatoPersona.setTipdatperDescripcion(bean.getRegistroParametro().getNombre());
                civTipoDatoPersona.setTipdatperNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTipoPersonasDAO().update(civTipoDatoPersona);
                break;

        }

    }

    public void save(BeanGestionParametros bean) throws Exception {
        switch (bean.getRegistroParametro().getNombreTabla()) {
            case "CIV_TIPOSDOCUMENTOS":
                CivTipodocumentos civTipoDocuementos = new CivTipodocumentos();

                civTipoDocuementos.setTipdocCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoDocuementos.setTipdocEstado(BigDecimal.valueOf(bean.getRegistroParametro().getEstado()));
                civTipoDocuementos.setTipdocFechainicial(bean.getRegistroParametro().getFechaInicial());
                civTipoDocuementos.setTipdocFechafinal(bean.getRegistroParametro().getFechaFinal());
                civTipoDocuementos.setTipdocNombre(bean.getRegistroParametro().getNombre());
                civTipoDocuementos.setTipdocNombrecorto(bean.getRegistroParametro().getNombreCorto());
                civTipoDocuementos.setTipdocId(new BigDecimal(getTiposDocumentosDAO().insert(civTipoDocuementos)));
                break;
            case "CIV_TIPOCONCEPTO":
                CivTipoconcepto civTipoconcepto = new CivTipoconcepto();
                civTipoconcepto.setTipconId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoconcepto.setTipconCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoconcepto.setTipconEstado(BigDecimal.valueOf(bean.getRegistroParametro().getEstado()));
                civTipoconcepto.setTipconFechainicial(bean.getRegistroParametro().getFechaInicial());
                civTipoconcepto.setTipconFechafinal(bean.getRegistroParametro().getFechaFinal());
                civTipoconcepto.setTipconDescripcion(bean.getRegistroParametro().getNombre());
                civTipoconcepto.setTipconNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTipoConceptosDAO().insert(civTipoconcepto);
                break;
            case "CIV_TIPODEUDA":
                CivTipodeuda civTipoDeuda = new CivTipodeuda();
                civTipoDeuda.setTipdeuId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoDeuda.setTipdeuCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoDeuda.setTipdeuEstado(BigDecimal.valueOf(bean.getRegistroParametro().getEstado()));
                civTipoDeuda.setTipdeuFechainicial(bean.getRegistroParametro().getFechaInicial());
                civTipoDeuda.setTipdeuFechafinal(bean.getRegistroParametro().getFechaFinal());
                civTipoDeuda.setTipdeuDescripcion(bean.getRegistroParametro().getNombre());
                civTipoDeuda.setTipdeuNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTipoDeudaDAO().insert(civTipoDeuda);
                break;
            case "CIV_TIPODATOPERSONA":
                CivTipodatopersona civTipoDatosPersona = new CivTipodatopersona();
                civTipoDatosPersona.setTipdatperId(BigDecimal.valueOf(bean.getRegistroParametro().getId()));
                civTipoDatosPersona.setTipdatperCodigo(BigDecimal.valueOf(bean.getRegistroParametro().getCodigo()));
                //civTipoDatosPersona.setTipdatperEstado(BigDecimal.valueOf(bean.getRegistroParametro().getEstado()));
                civTipoDatosPersona.setTipdatperFechainical(bean.getRegistroParametro().getFechaInicial());
                civTipoDatosPersona.setTipdatperFechafinal(bean.getRegistroParametro().getFechaFinal());
                civTipoDatosPersona.setTipdatperDescripcion(bean.getRegistroParametro().getNombre());
                civTipoDatosPersona.setTipdatperNombrecorto(bean.getRegistroParametro().getNombreCorto());
                getTipoPersonasDAO().insert(civTipoDatosPersona);
                break;

        }

    }

    public ITTipoConceptos getTipoConceptosDAO() {
        return tipoConceptosDAO;
    }

    public void setTipoConceptosDAO(ITTipoConceptos tipoConceptosDAO) {
        this.tipoConceptosDAO = tipoConceptosDAO;
    }

    /**
     * @return the loginDAO
     */
    public ITLogin getLoginDAO() {
        return loginDAO;
    }

    /**
     * @param loginDAO the loginDAO to set
     */
    public void setLoginDAO(ITLogin loginDAO) {
        this.loginDAO = loginDAO;
    }

    /**
     * @return the tablasParametricasDAO
     */
    public ITTablasParametricas getTablasParametricasDAO() {
        return tablasParametricasDAO;
    }

    /**
     * @param tablasParametricasDAO the tablasParametricasDAO to set
     */
    public void setTablasParametricasDAO(ITTablasParametricas tablasParametricasDAO) {
        this.tablasParametricasDAO = tablasParametricasDAO;
    }

    public ITTipoDocumento getTiposDocumentosDAO() {
        return tiposDocumentosDAO;
    }

    public void setTiposDocumentosDAO(ITTipoDocumento tiposDocumentosDAO) {
        this.tiposDocumentosDAO = tiposDocumentosDAO;
    }

    public ITTipoDeuda getTipoDeudaDAO() {
        return tipoDeudaDAO;
    }

    public void setTipoDeudaDAO(ITTipoDeuda tipoDeudaDAO) {
        this.tipoDeudaDAO = tipoDeudaDAO;
    }

    /**
     * @return the tipoPersonasDAO
     */
    public ITTipoPersonas getTipoPersonasDAO() {
        return tipoPersonasDAO;
    }

    /**
     * @param tipoPersonasDAO the tipoPersonasDAO to set
     */
    public void setTipoPersonasDAO(ITTipoPersonas tipoPersonasDAO) {
        this.tipoPersonasDAO = tipoPersonasDAO;
    }

    /**
     * @return the estadoTipoDocumentoDAO
     */
    public ITEstadoTipoDocumento getEstadoTipoDocumentoDAO() {
        return estadoTipoDocumentoDAO;
    }

    /**
     * @param estadoTipoDocumentoDAO the estadoTipoDocumentoDAO to set
     */
    public void setEstadoTipoDocumentoDAO(ITEstadoTipoDocumento estadoTipoDocumentoDAO) {
        this.estadoTipoDocumentoDAO = estadoTipoDocumentoDAO;
    }

}
