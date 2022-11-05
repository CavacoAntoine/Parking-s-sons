package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.message.ResponseMessage;
import com.agile.psbackspringboot.model.Horrodateur;
import com.agile.psbackspringboot.model.Place;
import com.agile.psbackspringboot.model.Voiture;
import com.agile.psbackspringboot.repository.PlaceRepository;
import com.agile.psbackspringboot.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Random;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/test")
public class TestRESTController {

    VoitureRepository voitureRepository;
    PlaceRepository placeRepository;

    @Autowired
    public TestRESTController(VoitureRepository voitureRepository,PlaceRepository placeRepository){
        this.voitureRepository = voitureRepository;
        this.placeRepository = placeRepository;
    }

    @PostMapping()
    public ResponseEntity<?> test(){
        Random rand = new Random();
        boolean malGare = false;
        boolean dureeDepasse = false;
        
        Calendar arrivé = Calendar.getInstance();
        arrivé.set(2022,Calendar.DECEMBER,6,rand.nextInt(15)+6,rand.nextInt(60));
        
        Calendar depart = arrivé;
        Calendar test = arrivé;

        depart.add(Calendar.HOUR,rand.nextInt(12)+1);
        test.add(Calendar.HOUR,rand.nextInt(12)+1);
        if(depart.before(test)){
            dureeDepasse = true;
        }

        if(rand.nextInt(100) < 5){
            malGare = true;
        }
        Horrodateur horrodateur = new Horrodateur(getARandomVoiture(),getARandomPlace(),arrivé,depart,dureeDepasse, malGare);


        return new ResponseEntity<>(new ResponseMessage("simulation faite"), HttpStatus.CREATED);
    }

    public Voiture getARandomVoiture(){
        List<Voiture> listV = voitureRepository.findAll();
        Random rand = new Random();
        return listV.get(rand.nextInt(listV.size()));
    }

    public Place getARandomPlace(){
        List<Place> listV = placeRepository.findAll();
        Random rand = new Random();
        return listV.get(rand.nextInt(listV.size()));
    }



}
