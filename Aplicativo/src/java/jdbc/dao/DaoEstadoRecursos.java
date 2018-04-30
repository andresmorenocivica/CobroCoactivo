/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivEstadorecursos;

/**
 *
 * @author jvergara
 */
public class DaoEstadoRecursos extends HibernateDaoSupport implements ITEstadoRecursos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivEstadorecursos estadorecursos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(estadorecursos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivEstadorecursos estadorecursos) throws Exception {
        getHibernateTemplate().merge(estadorecursos);
        return true;
    }

    @Override
    public List<CivEstadorecursos> listAll() throws Exception {
        String hql = "from CivEstadorecursos";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

}
