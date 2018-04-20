/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivTipoconcepto;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public interface ITTipoConceptos {
    
      public long insert(CivTipoconcepto civTipoconcepto)throws Exception;
    
    public boolean update(CivTipoconcepto civTipoconcepto)throws Exception;
    
    public List<CivTipoconcepto> listAll()throws Exception;
}
