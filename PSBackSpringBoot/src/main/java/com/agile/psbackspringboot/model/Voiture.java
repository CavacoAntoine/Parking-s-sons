package com.agile.psbackspringboot.model;

import com.agile.psbackspringboot.enums.TypeCar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voiture {

    @Id
    private String plaque;

    TypeCar type;

    @ManyToOne
    Personne proprietaire;

    Voiture(){

    }

    Voiture(String plaque, TypeCar type, Personne proprietaire){
        this.plaque = plaque;
        this.type = type;
        this.proprietaire = proprietaire;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public TypeCar getType() {
        return type;
    }

    public void setType(TypeCar type) {
        this.type = type;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }
}
