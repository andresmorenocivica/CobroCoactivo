/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanLogin;
import java.io.Serializable;
import jdbc.dao.ITLogin;

/**
 *
 * @author jvergara
 */
public class GestionMovimientosImpBO implements GestionMovimientosBO, Serializable {
    
private ITLogin loginDAO;

    /**
     * @return the loginDAO
     */
    public ITLogin getLoginDAO() {
        return loginDAO;
    }

    /**
     * @param loginDAO the loginDAO to set
     */
    public void setLoginDAO(ITLogin loginDAO) {
        this.loginDAO = loginDAO;
    }

   
    
}
