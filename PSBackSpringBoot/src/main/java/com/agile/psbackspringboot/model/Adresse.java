package com.agile.psbackspringboot.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adresse {

    @Id
    @GeneratedValue
    private long id;

    private int numero;
    private String rue;
    private String ville;
    private int codePostal;

    public long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;

        Adresse adresse = (Adresse) o;

        return new EqualsBuilder().append(this.numero,adresse.numero)
                .append(this.rue.toUpperCase(),adresse.rue.toUpperCase())
                .append(this.ville.toUpperCase(), adresse.ville.toUpperCase())
                .append(this.codePostal, adresse.codePostal)
                .isEquals();
    }
}
