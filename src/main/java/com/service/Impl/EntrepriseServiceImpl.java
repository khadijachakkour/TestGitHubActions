package com.service.Impl;

import com.dao.EntrepriseDao;
import com.entities.Entreprise;
import com.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EntrepriseServiceImpl implements EntrepriseService {

    @Autowired
    EntrepriseDao entrepriseDao;
    @Override
    @Transactional
    public void saveOrUpdate(Entreprise e) {
        this.entrepriseDao.saveOrUpdate(e);

    }

    @Override
    @Transactional
    public void delete(Entreprise e) {
        this.entrepriseDao.delete(e);

    }

    @Override
    public Entreprise getById(int id) {
        return this.entrepriseDao.getById(id);
    }

    @Override
    @Transactional
    public List<Entreprise> getAll() {
        return this.entrepriseDao.getAll();
    }
}
