/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import persistencias.CivPlantillas;

/**
 *
 * @author Soporte 2
 */
public interface ITPlantillas {
    
    public CivPlantillas getPlantilla(int tipo) throws Exception;
    
}
