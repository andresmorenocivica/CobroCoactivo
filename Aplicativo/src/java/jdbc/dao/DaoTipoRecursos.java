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
import persistencias.CivTiporecursos;

/**
 *
 * @author amoreno
 */
public class DaoTipoRecursos extends HibernateDaoSupport implements ITTipoRecursos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivTiporecursos civTiporecursos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civTiporecursos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivTiporecursos civTiporecursos) throws Exception {
        getHibernateTemplate().update(civTiporecursos);
        return true;
    }

    @Override
    public List<CivTiporecursos> listAll() throws Exception {
        String hql = "from CivTiporecursos where tiprecFechafinal is null order by 1 asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public CivTiporecursos getTipoDocumento(BigDecimal tipoRecurso) throws Exception {
        String hql = "from CivTiporecursos where tiprecCodigo=:codigoRecurso";
        List list = getHibernateTemplate().findByNamedParam(hql, "codigoRecurso", tipoRecurso);
        if (list.size() > 0) {
            return (CivTiporecursos) list.get(0);
        }
        return null;
    }

    
}
