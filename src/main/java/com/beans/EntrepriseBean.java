package com.beans;

import com.entities.Entreprise;
import com.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean
@Scope("session")
public class EntrepriseBean {

    @Autowired
    private EntrepriseService entrepriseService;

    private Entreprise entreprise;

    private boolean modifyContext;

    public EntrepriseBean()
    {
        this.entreprise=new Entreprise();
        this.modifyContext=false;
    }

    public String getLabel()
    {
        return isModifyContext()?"Modification":"Ajout";
    }

    public List<Entreprise> getEntreprises()
    {
        return this.entrepriseService.getAll();
    }

    @Transactional
    public void save() {

        this.entrepriseService.saveOrUpdate(this.entreprise);
        this.entreprise = new Entreprise();
        this.setModifyContext(false);
    }

    public void modify(Entreprise e) {

        this.entreprise = e;
        this.setModifyContext(true);
    }

    @Transactional
    public void delete(Entreprise e) {

        this.entrepriseService.delete(e);
        this.entreprise = new Entreprise();
    }
    public EntrepriseService getEntrepriseService() {
        return entrepriseService;
    }

    public void setEntrepriseService(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public boolean isModifyContext() {
        return modifyContext;
    }

    public void setModifyContext(boolean modifyContext) {
        this.modifyContext = modifyContext;
    }
}
