package com.agile.psbackspringboot.creator;

import com.agile.psbackspringboot.model.Adresse;
import com.agile.psbackspringboot.model.Parking;

public class ParkingFactory {

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
        this.nom = this.nom.toUpperCase();
        this.adresse.setRue(this.adresse.getRue().toLowerCase());
        String ville = this.adresse.getVille();
        this.adresse.setVille(ville.substring(0,1).toUpperCase() + ville.substring(1).toLowerCase());
        return new Parking(nom, adresse, nbrNormPlace, nbrHandiPlace, nbrLongPlace, nbrDeuxRPlace, nbrElecPlace);
    }

}
