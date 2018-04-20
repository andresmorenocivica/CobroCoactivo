/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivTipodeuda;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public class DaoTipoDeuda extends HibernateDaoSupport implements ITTipoDeuda {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivTipodeuda civTipodeuda) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civTipodeuda).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivTipodeuda civTipodeuda) throws Exception {
        getHibernateTemplate().update(civTipodeuda);
        return true;
    }

    @Override
    public List<CivTipodeuda> listAll() throws Exception {
        String hql = "from CivTipodeuda where tipdeuFechafinal is null order by 1 asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

}
