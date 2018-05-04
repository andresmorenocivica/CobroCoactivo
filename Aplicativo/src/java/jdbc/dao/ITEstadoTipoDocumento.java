/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivEstadotipodocumentos;

/**
 *
 * @author amoreno
 */
public interface ITEstadoTipoDocumento {
      public long insert(CivEstadotipodocumentos estadotipodocumentos) throws Exception;

    public boolean update(CivEstadotipodocumentos estadotipodocumentos) throws Exception;

    public List<CivEstadotipodocumentos> listAll() throws Exception;
    
    public CivEstadotipodocumentos consultarById(int esttipdocId) throws Exception;
}
