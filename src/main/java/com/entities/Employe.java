package com.entities;

import javax.persistence.*;

import java.util.Objects;

@Entity
public class Employe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEmploye", nullable = false)
    private int idEmploye;
    @Basic
    @Column(name = "nomEmploye", nullable = false, length = 40)
    private String nomEmploye;
    @Basic
    @Column(name = "telEmploye", nullable = false, length = 40)
    private String telEmploye;
    @Basic
    @Column(name = "salaireEmploye", nullable = false, precision = 0)
    private double salaireEmploye;
    @ManyToOne
    @JoinColumn(name = "entreprise", referencedColumnName = "idEntreprise", nullable = false)
    private Entreprise entrepriseByEntreprise;

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getTelEmploye() {
        return telEmploye;
    }

    public void setTelEmploye(String telEmploye) {
        this.telEmploye = telEmploye;
    }

    public double getSalaireEmploye() {
        return salaireEmploye;
    }

    public void setSalaireEmploye(double salaireEmploye) {
        this.salaireEmploye = salaireEmploye;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return idEmploye == employe.idEmploye && Double.compare(employe.salaireEmploye, salaireEmploye) == 0 && Objects.equals(nomEmploye, employe.nomEmploye) && Objects.equals(telEmploye, employe.telEmploye);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmploye, nomEmploye, telEmploye, salaireEmploye);
    }

    public Entreprise getEntrepriseByEntreprise() {
        return entrepriseByEntreprise;
    }

    public void setEntrepriseByEntreprise(Entreprise entrepriseByEntreprise) {
        this.entrepriseByEntreprise = entrepriseByEntreprise;
    }
}
