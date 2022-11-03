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

}
