/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivEstadopersona;

/**
 *
 * @author amoreno
 */
public interface ITEstadosPersona {

    public long insert(CivEstadopersona estadopersona) throws Exception;

    public boolean update(CivEstadopersona estadopersona) throws Exception;

    public List<CivEstadopersona> listAll() throws Exception;
    
    public CivEstadopersona consultarById(int estperId) throws Exception;
}
