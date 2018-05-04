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
import persistencias.CivEstadotipodocumentos;

/**
 *
 * @author amoreno
 */
public class DaoEstadoTipoDocumento extends HibernateDaoSupport implements ITEstadoTipoDocumento {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivEstadotipodocumentos estadotipodocumentos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(estadotipodocumentos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivEstadotipodocumentos estadotipodocumentos) throws Exception {
        getHibernateTemplate().merge(estadotipodocumentos);
        return true;
    }

    @Override
    public List<CivEstadotipodocumentos> listAll() throws Exception {
        String hql = "from CivEstadotipodocumentos where esttipdocFechafinal is null";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public CivEstadotipodocumentos consultarById(int esttipdocId) throws Exception {
         String hql = "from CivEstadotipodocumentos where esttipdocId =:esttipdocId";
        List list = getHibernateTemplate().findByNamedParam(hql, "esttipdocId", BigDecimal.valueOf(esttipdocId));
        if (list.size() > 0) {
            return (CivEstadotipodocumentos) list.get(0);
        }
        return null;
    }

}
