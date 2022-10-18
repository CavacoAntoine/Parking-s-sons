package com.agile.psbackspringboot.model;

import com.agile.psbackspringboot.enums.TypePlace;
import com.agile.psbackspringboot.exceptions.PlaceNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parking {

    private String nom;
    private List<Place> places;
    private String adresse;



    /**
     * Initie un parking avec le nombres de place par type d�finis par les param�tres.
     * Toutes les places se voient affect�e un num�ro unique et tous les num�ros se suivent	 *
     * @param nbPlaceNormal
     * @param nbPlaceHandicape
     * @param nbPlaceLong
     * @param nbPlace2roues
     * @param nbPlaceElec
     */
    public Parking(int nbPlaceNormal,int nbPlaceHandicape,int nbPlaceLong,int nbPlace2roues, int nbPlaceElec, String adresse) {
        if (nbPlaceNormal<0) {
            throw new InstantiationError("interdit de mettre des nombres negatifs");
        }
        if (adresse==null) {
            throw new InstantiationError("interdit adresse null");
        }
        this.places = new ArrayList<Place>();


        List<Place> placesNominale = createListePlaceForType(nbPlaceNormal, TypePlace.NORMALE, 1);
        places.addAll(placesNominale);

        List<Place> placesHandicape = createListePlaceForType(nbPlaceHandicape, TypePlace.HANDICAPE,places.size()+1);
        places.addAll(placesHandicape);

        List<Place> placesBus = createListePlaceForType(nbPlaceLong, TypePlace.LONG, places.size()+1);
        places.addAll(placesBus);

        List<Place> places2roues = createListePlaceForType(nbPlace2roues, TypePlace.DEUX_ROUES, places.size()+1);
        places.addAll(places2roues);

        List<Place> placesElec = createListePlaceForType(nbPlaceElec, TypePlace.ELECTRIQUE, places.size()+1);
        places.addAll(placesElec);
    }

    private List<Place> createListePlaceForType(int nombre, TypePlace typePlace, int numeroDepart){
        if (nombre<0) {
            throw new InstantiationError("le nombre de place pour le type"+typePlace+" doit etre >= 0");
        }
        List<Place> places = new ArrayList<Place>();
        for (int i = 0; i<nombre; i++) {
            Place place = new Place(typePlace, i+numeroDepart);
            places.add(place);
        }

        return places;

    }

    /**
     * renvoie toutes les places libre qui correspondent au type de place recherch�
     * @param type
     * @return
     */
    public List<Place> searchPlaceLibre(TypePlace type){
        //TODO
        return Collections.emptyList();
    }

    /**
     * le statut de la place de numéro numero passe à occupe
     * @param numero
     * @throws PlaceNotFoundException si la place de numéro numero n'existe pas
     */
    public void occuperPlace(int numero) throws PlaceNotFoundException {
        //TODO
    }

    /**
     * le statut de la place de numéro numero passe à occupe
     * @param numero
     */
    public void libererPlace(int numero) throws PlaceNotFoundException{
        //TODO
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    protected List<Place> getPlaces() {
        return places;

    }
}
