/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import persistencias.CivProcesosjuridicos;

/**
 *
 * @author Admin
 */
public interface ITProcesosJuridicos {
    public long insert(CivProcesosjuridicos civProcesosjuridicos) throws Exception;

    public boolean update(CivProcesosjuridicos civProcesosjuridicos) throws Exception;
    
    public CivProcesosjuridicos getConcepto(int projuId) throws Exception;
}
