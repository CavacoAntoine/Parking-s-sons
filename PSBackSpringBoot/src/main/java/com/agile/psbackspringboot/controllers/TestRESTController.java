package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.enums.TypeCar;
import com.agile.psbackspringboot.message.ResponseMessage;
import com.agile.psbackspringboot.model.Horrodateur;
import com.agile.psbackspringboot.model.Place;
import com.agile.psbackspringboot.model.Voiture;
import com.agile.psbackspringboot.repository.HorrodateurRepository;
import com.agile.psbackspringboot.repository.PlaceRepository;
import com.agile.psbackspringboot.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/test")
public class TestRESTController {

    VoitureRepository voitureRepository;
    PlaceRepository placeRepository;
    HorrodateurRepository horrodateurRepository;

    @Autowired
    public TestRESTController(VoitureRepository voitureRepository, PlaceRepository placeRepository, HorrodateurRepository horrodateurRepository) {
        this.voitureRepository = voitureRepository;
        this.placeRepository = placeRepository;
        this.horrodateurRepository = horrodateurRepository;
    }

    @PostMapping("/{number}")
    public ResponseEntity<?> test(@PathVariable("number") int nombre){
        List<Voiture> voitures = voitureRepository.findAll();
        List<Place> places = placeRepository.findAll();

        if(nombre >= voitures.size() && nombre >= places.size()) {
            return new ResponseEntity<>(new ResponseMessage("Le nombre demandé doit être inférieur au nombre de " +
                    "voitures et de " + "places dans la bdd soit <" + voitures.size() + " && <" + places.size()),
                    HttpStatus.BAD_REQUEST);
        }

        places.forEach(place -> place.setLibre(true));
        this.placeRepository.saveAll(places);
        this.horrodateurRepository.deleteAll();

        Random randomV = new Random();
        Random randomP = new Random();
        Random randomH = new Random();
        Random randomM = new Random();

        for(int i = 0 ; i < nombre; i++) {
            boolean malGare = false;
            boolean dureeDepasse = false;
            Voiture voiture =  new Voiture();
            Place place = new Place();

            boolean find = false;

            while(!find) {
                voiture = getARandomVoiture(randomV, voitures);
                if(horrodateurRepository.findByVoiture(voiture) == null)
                    find = true;
            }

            find = false;

            while(!find) {
                place = getARandomPlace(randomP, places);
                if(horrodateurRepository.findByPlace(place) == null)
                    find = true;
            }

            if(place.getType() != voiture.getType()){
                if(voiture.getType() == TypeCar.ELECTRIQUE && place.getType() == TypeCar.NORMALE)
                    malGare = false;
                else if(voiture.getType() == TypeCar.HANDICAPE && place.getType() == TypeCar.NORMALE)
                    malGare = false;
                else
                    malGare = true;
            }

            Calendar arrive = Calendar.getInstance();
            arrive.add(Calendar.HOUR_OF_DAY, -randomH.nextInt(23));
            arrive.add(Calendar.MINUTE, -randomM.nextInt(60));

            Calendar depart = (Calendar) arrive.clone();
            depart.add(Calendar.HOUR_OF_DAY, randomH.nextInt(72));
            depart.add(Calendar.MINUTE, randomM.nextInt(60));

            if(depart.compareTo(Calendar.getInstance()) < 0 ) {
                dureeDepasse = true;
            }

            place.setLibre(false);
            placeRepository.save(place);
            horrodateurRepository.save(new Horrodateur(voiture, place, new Date(arrive.getTime().getTime()), depart.getTime(), dureeDepasse, malGare));
        }

        return new ResponseEntity<>(new ResponseMessage("simulation faite"), HttpStatus.CREATED);
    }

    public Voiture getARandomVoiture(Random random, List<Voiture> voitures){
        return voitures.get(random.nextInt(voitures.size()));
    }

    public Place getARandomPlace(Random random, List<Place> places){
        return places.get(random.nextInt(places.size()));
    }

}
