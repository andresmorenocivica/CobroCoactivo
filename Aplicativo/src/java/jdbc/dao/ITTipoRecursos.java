/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.math.BigDecimal;
import java.util.List;
import persistencias.CivTiporecursos;

/**
 *
 * @author amoreno
 */
public interface ITTipoRecursos {

    public long insert(CivTiporecursos civTiporecursos) throws Exception;

    public boolean update(CivTiporecursos civTiporecursos) throws Exception;

    public List<CivTiporecursos> listAll() throws Exception;
    
      public CivTiporecursos getTipoDocumento(BigDecimal tipoRecurso) throws Exception;
}
