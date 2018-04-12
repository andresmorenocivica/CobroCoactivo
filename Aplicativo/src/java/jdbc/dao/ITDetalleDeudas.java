/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import persistencias.CivDetalleDeudas;

/**
 *
 * @author Admin
 */
public interface ITDetalleDeudas {
         public long insert(CivDetalleDeudas civDetalleDeudas) throws Exception;

    public boolean update(CivDetalleDeudas civDetalleDeudas) throws Exception;
    
    public CivDetalleDeudas getConcepto(int detdeuId) throws Exception;
}
