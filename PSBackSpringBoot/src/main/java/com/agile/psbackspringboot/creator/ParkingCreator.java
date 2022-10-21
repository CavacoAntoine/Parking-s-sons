package com.agile.psbackspringboot.creator;

import com.agile.psbackspringboot.model.Adresse;
import com.agile.psbackspringboot.model.Parking;

public class ParkingCreator {

    private String nom;
    private int nbrNormPlace;
    private int nbrHandiPlace;
    private int nbrDeuxRPlace;
    private  int nbrLongPlace;
    private int nbrElecPlace;
    private Adresse adresse;

    public String getNom() {
        return nom;
    }

    public int getNbrNormPlace() {
        return nbrNormPlace;
    }

    public int getNbrHandiPlace() {
        return nbrHandiPlace;
    }

    public int getNbrDeuxRPlace() {
        return nbrDeuxRPlace;
    }

    public int getNbrLongPlace() {
        return nbrLongPlace;
    }

    public int getNbrElecPlace() {
        return nbrElecPlace;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Parking create(){
        return new Parking(nom, adresse, nbrNormPlace, nbrHandiPlace, nbrLongPlace, nbrDeuxRPlace, nbrElecPlace);
    }

}
