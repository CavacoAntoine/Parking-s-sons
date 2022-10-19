package com.agile.psbackspringboot.model;

import com.agile.psbackspringboot.enums.TypePlace;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Place {

    @Id
    @GeneratedValue
    private long numero;

    private TypePlace type;
    private boolean libre;

    public Place() {
        this(TypePlace.NORMALE, 1);
    }

    public Place(TypePlace type, int numero) {
        this.type=type;
        this.libre= true;
        this.numero = numero;
    }

    public TypePlace getType() {
        return type;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre=libre;
    }

    public long getNumero() {
        return this.numero;
    }
}
