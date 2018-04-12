/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import persistencias.CivDetalleProcesojuridico;

/**
 *
 * @author Admin
 */
public interface ITDetalleProcesosJuridicos {
    public long insert(CivDetalleProcesojuridico civDetalleProcesojuridico) throws Exception;

    public boolean update(CivDetalleProcesojuridico civDetalleProcesojuridico) throws Exception;
    
    public CivDetalleProcesojuridico getConcepto(int detprojuId) throws Exception;
}
