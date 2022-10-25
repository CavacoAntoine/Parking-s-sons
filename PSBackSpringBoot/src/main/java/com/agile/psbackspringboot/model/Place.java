package com.agile.psbackspringboot.model;

import com.agile.psbackspringboot.enums.TypePlace;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Place {

    @Id
    @GeneratedValue
    private long id;

    private int numero;
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

    public long getId() {
        return this.id;
    }

    public TypePlace getType() {
        return type;
    }

    public void setType(TypePlace type) {
        if(type == null) throw new IllegalArgumentException();
        this.type = type;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre=libre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
