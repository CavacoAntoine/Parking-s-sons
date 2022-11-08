package com.agile.psbackspringboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Horodateur {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Voiture voiture;

    @OneToOne
    private Place place;

    private Date dateArrivee;

    private Date dateDepart;

    private boolean dureeDepasse;

    private boolean malGare;

    public Horodateur() {
    }

    public Horodateur(Voiture voiture, Place place, Date hArrivee, Date dDepart, boolean dureeDepasse, boolean malGare) {
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

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
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

    public boolean isBad(){
        if(isMalGare() || isDureeDepasse()){
            return true;
        } else if (this.dateDepart.compareTo(new Date()) < 0) {
            this.dureeDepasse = true;
            return true;
        }
        return false;
    }
}
