/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;


import java.util.List;
import persistencias.CivTipodeuda;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public interface ITTipoDeuda {

    public long insert(CivTipodeuda civTipodeuda) throws Exception;

    public boolean update(CivTipodeuda civTipodeuda) throws Exception;

    public List<CivTipodeuda> listAll() throws Exception;

}
