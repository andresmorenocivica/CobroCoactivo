/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivEstadousuarios;

/**
 *
 * @author amoreno
 */
public interface ITEstadoUsuarios {
    
    public long insert(CivEstadousuarios estadousuarios)throws Exception;
    
    public boolean update(CivEstadousuarios estadousuarios)throws Exception;
    
    public List<CivEstadousuarios> listAll()throws Exception;
    
    
    public CivEstadousuarios consultarModuloById(int id) throws Exception;
}
