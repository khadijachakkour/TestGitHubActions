package com.service;

import com.entities.Entreprise;
import java.util.List;

public interface EntrepriseService {

    void saveOrUpdate(Entreprise e);
    void delete(Entreprise e);
    Entreprise getById(int id);
    List<Entreprise> getAll();
}
