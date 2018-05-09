/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivEstadodetalleProceso;
import persistencias.CivEstadoprocesojuridicos;

/**
 *
 * @author pruebadesarrollo
 */
public interface ITEstadoProcesoJuridico {

    public long insert(CivEstadodetalleProceso estadodetalleProceso) throws Exception;

     public boolean update(CivEstadodetalleProceso estadodetalleProceso) throws Exception;
    
    public List<CivEstadoprocesojuridicos> listAll() throws Exception;

    public CivEstadoprocesojuridicos consultaById(int estproId) throws Exception;
}
