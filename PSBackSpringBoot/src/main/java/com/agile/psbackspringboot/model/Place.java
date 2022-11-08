package com.agile.psbackspringboot.model;

import com.agile.psbackspringboot.enums.TypeCar;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Place {

    @Id
    @GeneratedValue
    private long id;

    private int numero;
    private TypeCar type;
    private boolean libre;

    public Place() {
        this(TypeCar.NORMALE, 1);
    }

    public Place(TypeCar type, int numero) {
        this.type=type;
        this.libre= true;
        this.numero = numero;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeCar getType() {
        return type;
    }

    public void setType(TypeCar type) {
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
        if(numero < 0) throw new IllegalArgumentException();
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;

        Place place = (Place) o;

        return new EqualsBuilder().append(this.numero, place.numero).append(this.type, place.type).append(this.libre, place.libre).isEquals();
    }
}
