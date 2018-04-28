/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionEstados;
import java.io.Serializable;
import java.util.List;
import jdbc.dao.ITEstadosParametricos;
import jdbc.dao.ITEstadosPersona;
import jdbc.dao.ITLogin;
import model.EstadosDatos;
import model.tablaEstadosParametricos;
import persistencias.CivEstadopersona;
import persistencias.CivEstadosparametricos;

/**
 *
 * @author amoreno
 */
public class GestionEstadosImpBO implements GestionEstadosBO, Serializable {

    private ITLogin loginDAO;
    private ITEstadosParametricos estadosPatametricosDAO;
    private ITEstadosPersona estadosPersonaDAO;

    @Override
    public void llenarDatos(BeanGestionEstados bean) throws Exception {

        int registro = 0;
        List<CivEstadosparametricos> listCivEstadosParametricos = getEstadosPatametricosDAO().listAll();
        for (CivEstadosparametricos civEstadosParametrico : listCivEstadosParametricos) {
            tablaEstadosParametricos tablasEstadosParametricos = new tablaEstadosParametricos();
            tablasEstadosParametricos.setNombreTabla(civEstadosParametrico.getEstparNombretabla());
            tablasEstadosParametricos.setNombre(civEstadosParametrico.getEstparNombre());
            tablasEstadosParametricos.setId(civEstadosParametrico.getEstparId().intValue());
            tablasEstadosParametricos.setFechaInicial(civEstadosParametrico.getEstparFechainicial());
            tablasEstadosParametricos.setFechaFinal(civEstadosParametrico.getEstparFechafinal());
            bean.getListaTablaEstadosParametricos().add(tablasEstadosParametricos);
            switch (civEstadosParametrico.getEstparNombretabla()) {
                case "CIV_ESTADOPERSONA":
                    List<CivEstadopersona> listCivEstadosPersona = getEstadosPersonaDAO().listAll();
                    for (CivEstadopersona civEstadopersona : listCivEstadosPersona) {
                        EstadosDatos estadosDatos = new EstadosDatos();
                        estadosDatos.setId(civEstadopersona.getEstperId().intValue());
                        estadosDatos.setNombreTabla(civEstadosParametrico.getEstparNombretabla());
                        estadosDatos.setDescripcion(civEstadopersona.getEstperDescripcion());
                        estadosDatos.setFechaInicial(civEstadopersona.getEstperFechainicial());
                        estadosDatos.setFechaFinal(civEstadopersona.getEstperFechafinal());
                        bean.getListaTablaEstadosParametricos().get(registro).getListaDatosEstados().add(estadosDatos);
                    }

                    break;
            }
            registro++;
        }
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
     * @return the estadosPatametricosDAO
     */
    public ITEstadosParametricos getEstadosPatametricosDAO() {
        return estadosPatametricosDAO;
    }

    /**
     * @param estadosPatametricosDAO the estadosPatametricosDAO to set
     */
    public void setEstadosPatametricosDAO(ITEstadosParametricos estadosPatametricosDAO) {
        this.estadosPatametricosDAO = estadosPatametricosDAO;
    }

    /**
     * @return the estadosPersonaDAO
     */
    public ITEstadosPersona getEstadosPersonaDAO() {
        return estadosPersonaDAO;
    }

    /**
     * @param estadosPersonaDAO the estadosPersonaDAO to set
     */
    public void setEstadosPersonaDAO(ITEstadosPersona estadosPersonaDAO) {
        this.estadosPersonaDAO = estadosPersonaDAO;
    }

}
