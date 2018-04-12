/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import persistencias.CivConceptos;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
public class DaoConceptos extends HibernateDaoSupport implements ITConceptos{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivConceptos civConcepto) throws Exception {
         return Long.parseLong(getHibernateTemplate().save(civConcepto).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivConceptos civConcepto) throws Exception {
        getHibernateTemplate().update(civConcepto);
        return true;
    }

    @Override
    public CivConceptos getConcepto(int con_id) throws Exception {
        String hql = "from CivConceptos where conId=:conId";
        List list = getHibernateTemplate().findByNamedParam(hql, "conId", new BigDecimal(con_id));
        if (list.size() > 0) {
            return (CivConceptos) list.get(0);
        }
        return null;
    }
    
}
