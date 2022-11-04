package com.agile.psbackspringboot.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Horrodateur {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Voiture voiture;

    @OneToOne
    private Place place;

    private Calendar dateArrivee;

    private Calendar dateDepart;

    private boolean dureeDepasse;

    private boolean malGare;

    public Horrodateur() {
    }

    public Horrodateur(Voiture voiture, Place place, Calendar hArrivee, Calendar dDepart, boolean dureeDepasse, boolean malGare) {
        this.voiture = voiture;
        this.place = place;
        this.dateArrivee = hArrivee;
        this.dateDepart = dDepart;
        this.dureeDepasse = dureeDepasse;
        this.malGare = malGare;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Calendar getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Calendar dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Calendar getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Calendar dateDepart) {
        this.dateDepart = dateDepart;
    }

    public boolean isDureeDepasse() {
        return dureeDepasse;
    }

    public void setDureeDepasse(boolean dureeDepasse) {
        this.dureeDepasse = dureeDepasse;
    }

    public boolean isMalGare() {
        return malGare;
    }

    public void setMalGare(boolean malGare) {
        this.malGare = malGare;
    }
}
