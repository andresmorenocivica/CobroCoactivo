/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivEstadosparametricos;

/**
 *
 * @author amoreno
 */
public class DaoEstadosParametricos extends HibernateDaoSupport implements ITEstadosParametricos{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivEstadosparametricos estadosparametricos) throws Exception {
          return Long.parseLong(getHibernateTemplate().save(estadosparametricos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivEstadosparametricos estadosparametricos) throws Exception {
         getHibernateTemplate().merge(estadosparametricos);
        return true;
    }

    @Override
    public List<CivEstadosparametricos> listAll() throws Exception {
        String hql = "from CivEstadosparametricos";
        List list = getHibernateTemplate().find(hql);
        return list;
    }
    
}
