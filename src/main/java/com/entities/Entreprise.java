package com.entities;

import javax.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Entreprise {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEntreprise", nullable = false)
    private int idEntreprise;
    @Basic
    @Column(name = "nomEntreprise", nullable = false, length = 40)
    private String nomEntreprise;
    @Basic
    @Column(name = "villeEntreprise", nullable = false, length = 40)
    private String villeEntreprise;
    @Basic
    @Column(name = "telEntreprise", nullable = false, length = 40)
    private String telEntreprise;
    @OneToMany(mappedBy = "entrepriseByEntreprise")
    private Collection<Employe> employesByIdEntreprise;

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getVilleEntreprise() {
        return villeEntreprise;
    }

    public void setVilleEntreprise(String villeEntreprise) {
        this.villeEntreprise = villeEntreprise;
    }

    public String getTelEntreprise() {
        return telEntreprise;
    }

    public void setTelEntreprise(String telEntreprise) {
        this.telEntreprise = telEntreprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entreprise that = (Entreprise) o;
        return idEntreprise == that.idEntreprise && Objects.equals(nomEntreprise, that.nomEntreprise) && Objects.equals(villeEntreprise, that.villeEntreprise) && Objects.equals(telEntreprise, that.telEntreprise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEntreprise, nomEntreprise, villeEntreprise, telEntreprise);
    }

    public Collection<Employe> getEmployesByIdEntreprise() {
        return employesByIdEntreprise;
    }

    public void setEmployesByIdEntreprise(Collection<Employe> employesByIdEntreprise) {
        this.employesByIdEntreprise = employesByIdEntreprise;
    }
}
