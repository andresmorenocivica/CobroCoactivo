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
import persistencias.CivDetalleDeudas;

/**
 *
 * @author Admin
 */
public class DaoDetalleDeudas extends HibernateDaoSupport implements ITDetalleDeudas{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivDetalleDeudas civDetalleDeudas) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civDetalleDeudas).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivDetalleDeudas civDetalleDeudas) throws Exception {
        getHibernateTemplate().update(civDetalleDeudas);
        return true;
    }

    @Override
    public CivDetalleDeudas getConcepto(int detdeuId) throws Exception {
         String hql = "from CivDetalleDeudas where detdeuId=:detdeuId";
        List list = getHibernateTemplate().findByNamedParam(hql, "detdeuId", new BigDecimal(detdeuId));
        if (list.size() > 0) {
            return (CivDetalleDeudas) list.get(0);
        }
        return null;
    }
    
}
