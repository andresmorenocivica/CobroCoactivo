/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivTipodatopersona;


/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public interface ITTipoPersonas {
    
  
    public long insert(CivTipodatopersona civTipodatopersona) throws Exception;

   
    public boolean update(CivTipodatopersona civTipodatopersona) throws Exception;
    
   
    public List<CivTipodatopersona> listAll() throws Exception;
    
}
