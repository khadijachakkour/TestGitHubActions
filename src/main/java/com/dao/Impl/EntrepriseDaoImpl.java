package com.dao.Impl;

import com.dao.EntrepriseDao;
import com.entities.Entreprise;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EntrepriseDaoImpl extends HibernateDaoSupport implements EntrepriseDao {

    @Autowired
    public void setUpSessionFactory(SessionFactory sf) {

        this.setSessionFactory(sf);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Entreprise e) {

        this.getHibernateTemplate().saveOrUpdate(e);
    }


    @Override
    @Transactional
    public void delete(Entreprise e) {

        this.getHibernateTemplate().delete(e);
    }

    @Override
    public Entreprise getById(int id) {

        return this.getHibernateTemplate().get(Entreprise.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Entreprise> getAll() {

        return (List<Entreprise>) this.getHibernateTemplate().findByCriteria(
                DetachedCriteria.forClass(Entreprise.class));
    }
}
