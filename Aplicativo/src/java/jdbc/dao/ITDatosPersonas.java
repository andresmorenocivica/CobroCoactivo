/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivDatospersona;

/**
 *
 * @author jvergara
 */
public interface ITDatosPersonas {
    
     public long insert(CivDatospersona civDatospersona)throws Exception;
    
    public boolean update(CivDatospersona civDatospersona)throws Exception;
    
    public List<CivDatospersona> listDatosPersonas(int idPersonas)throws Exception;
    
    public CivDatospersona getDatosPersona(int idPersonas)throws Exception;
    
    public CivDatospersona getDatoPersonaByIdPersonaByTipoDato(int idPersona,int idTipoDato) throws Exception;
    
}
