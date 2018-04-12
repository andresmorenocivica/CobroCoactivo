/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import persistencias.CivConceptos;

/**
 *
 * @author Admin
 */
public interface ITConceptos {
        
    public long insert(CivConceptos civConcepto) throws Exception;

    public boolean update(CivConceptos civConcepto) throws Exception;
    
    public CivConceptos getConcepto(int con_id) throws Exception;
}
