/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivTipodatopersona;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public class DaoTipoPersonas extends HibernateDaoSupport implements ITTipoPersonas {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivTipodatopersona civTipodatopersona) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civTipodatopersona).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivTipodatopersona civTipodatopersona) throws Exception {
        getHibernateTemplate().update(civTipodatopersona);
        return true;
    }

    @Override
    public List<CivTipodatopersona> listAll() throws Exception {
        String hql = "from CivTipodatopersona where tipdatperFechafinal is null order by 1 asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

}
