package com.agile.psbackspringboot.model;

import com.agile.psbackspringboot.enums.TypeCar;
import com.agile.psbackspringboot.exceptions.PlaceNotFoundException;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parking {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique=true)
    private String nom;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Place> places;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    public Parking() {
        this("EMPTY", new Adresse(), 0,0,0,0,0);
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Place> getPlaces() {
        return places;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Initie un parking avec le nombres de place par type d�finis par les param�tres.
     * Toutes les places se voient affect�e un num�ro unique et tous les num�ros se suivent
     * @param nom Le nom du parking
     * @param adresse L'adresse du parking
     * @param nbPlaceNormal Le nombre de place normal
     * @param nbPlaceHandicape Le nombre de place handicape
     * @param nbPlaceLong Le nompre de place longue
     * @param nbPlace2roues Le nombre de place pour 2 roues
     * @param nbPlaceElec Le nomre de place pour vehicule electrique
     */
    public Parking(String nom, Adresse adresse, int nbPlaceNormal,int nbPlaceHandicape,int nbPlaceLong,int nbPlace2roues, int nbPlaceElec) {
        if (nbPlaceNormal<0) {
            throw new InstantiationError("interdit de mettre des nombres negatifs");
        }
        if (adresse==null) {
            throw new InstantiationError("interdit adresse null");
        }
        this.nom = nom;
        this.adresse = adresse;
        this.places = new ArrayList<>();

        List<Place> placesNormale = createListePlaceForType(nbPlaceNormal, TypeCar.NORMALE, 1);
        places.addAll(placesNormale);

        List<Place> placesHandicape = createListePlaceForType(nbPlaceHandicape, TypeCar.HANDICAPE,places.size()+1);
        places.addAll(placesHandicape);

        List<Place> placesBus = createListePlaceForType(nbPlaceLong, TypeCar.LONG, places.size()+1);
        places.addAll(placesBus);

        List<Place> places2roues = createListePlaceForType(nbPlace2roues, TypeCar.DEUX_ROUES, places.size()+1);
        places.addAll(places2roues);

        List<Place> placesElec = createListePlaceForType(nbPlaceElec, TypeCar.ELECTRIQUE, places.size()+1);
        places.addAll(placesElec);
    }

    private List<Place> createListePlaceForType(int nombre, TypeCar typeCar, int numeroDepart){
        if (nombre<0) {
            throw new InstantiationError("le nombre de place pour le type"+ typeCar +" doit etre >= 0");
        }
        List<Place> places = new ArrayList<>();
        for (int i = 0; i<nombre; i++) {
            Place place = new Place(typeCar, i+numeroDepart);
            places.add(place);
        }

        return places;

    }

    /**
     * renvoie toutes les places libre qui correspondent au type de place recherch�
     * @param type Le type de place recherché
     * @return Une liste des places coresspondant au type
     */
    public List<Place> searchPlaceLibre(TypeCar type){
        return this.places.stream().filter(place -> (place.getType() == type && place.isLibre())).toList();
    }

    /**
     * le statut de la place de numéro numero passe à occupe
     * @param numero Le numero de la place
     * @throws PlaceNotFoundException si la place de numéro numero n'existe pas
     */
    public void occuperPlace(int numero) throws PlaceNotFoundException {
        for(Place place : this.places) {
            if(place.getNumero() == numero){
                place.setLibre(false);
                return;
            }
        }
        throw new PlaceNotFoundException(numero);
    }

    /**
     * le statut de la place de numéro numero passe à libre
     * @param numero Le numero de la place
     */
    public void libererPlace(int numero) throws PlaceNotFoundException{
        for(Place place : this.places) {
            if(place.getNumero() == numero){
                place.setLibre(true);
                return;
            }
        }
        throw new PlaceNotFoundException(numero);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;

        Parking parking = (Parking) o;

        return new EqualsBuilder().append(this.nom,parking.nom).append(this.places,parking.places).append(this.adresse,parking.adresse).isEquals();
    }
}
