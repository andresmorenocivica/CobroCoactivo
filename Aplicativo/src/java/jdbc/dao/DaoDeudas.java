/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivDeudas;

/**
 *
 * @author Admin
 */
public class DaoDeudas extends HibernateDaoSupport implements ITDeudas {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivDeudas civDeudas) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civDeudas).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivDeudas civDeudas) throws Exception {
        getHibernateTemplate().update(civDeudas);
        return true;
    }

    @Override
    public CivDeudas getDeuda(int deu_id) throws Exception {
        String hql = "from CivDeudas where deuId=:deuId";
        List list = getHibernateTemplate().findByNamedParam(hql, "deuId", new BigDecimal(deu_id));
        if (list.size() > 0) {
            return (CivDeudas) list.get(0);
        }
        return null;
    }
    
     @Override
    public List<CivDeudas>  buscarHistorialDeudasPersonas(int idPersonas) throws Exception {
        String hql = "from CivDeudas where civPersonas.perId=:deuId";
        List list = getHibernateTemplate().findByNamedParam(hql, "deuId", new BigDecimal(idPersonas));
       return list;
    }

}
