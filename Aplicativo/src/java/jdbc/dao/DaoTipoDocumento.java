/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package jdbc.dao;

import persistencias.CivTipodocumentos;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class DaoTipoDocumento extends HibernateDaoSupport implements ITTipoDocumento {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivTipodocumentos civTipodocumentos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civTipodocumentos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivTipodocumentos civTipodocumentos) throws Exception {
        getHibernateTemplate().update(civTipodocumentos);
        return true;
    }

    @Override

    public List<CivTipodocumentos> listAll() throws Exception {
        String hql = "from CivTipodocumentos where tipdocFechafinal is null order by 1 asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public CivTipodocumentos getTipoDocumento(BigDecimal codigoDocumento) throws Exception {
       String hql = "from CivTipodocumentos where tipdocCodigo=:codigoDocumento";
        List list = getHibernateTemplate().findByNamedParam(hql, "codigoDocumento", codigoDocumento);
        if (list.size() > 0) {
            return (CivTipodocumentos) list.get(0);
        }
        return null;
    }
}
