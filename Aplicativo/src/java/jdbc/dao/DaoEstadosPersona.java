/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivEstadopersona;

/**
 *
 * @author amoreno
 */
public class DaoEstadosPersona extends HibernateDaoSupport implements ITEstadosPersona{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivEstadopersona estadopersona) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(estadopersona).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivEstadopersona estadopersona) throws Exception {
        getHibernateTemplate().merge(estadopersona);
        return true;
    }

    @Override
    public List<CivEstadopersona> listAll() throws Exception {
        String hql = "from CivEstadopersona where estperFechafinal is null";
        List list = getHibernateTemplate().find(hql);
        return list;
    }
    
}
