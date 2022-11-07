package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.model.Horrodateur;
import com.agile.psbackspringboot.model.Place;
import com.agile.psbackspringboot.repository.HorrodateurRepository;
import com.agile.psbackspringboot.repository.ParkingRepository;
import com.agile.psbackspringboot.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/horrodateur")
public class HorrodateurRESTController {

    HorrodateurRepository horrodateurRepository;
    PlaceRepository placeRepository;
    ParkingRepository parkingRepository;

    @Autowired
    public HorrodateurRESTController(HorrodateurRepository horrodateurRepository, PlaceRepository placeRepository, ParkingRepository parkingRepository) {
        this.horrodateurRepository = horrodateurRepository;
        this.placeRepository = placeRepository;
        this.parkingRepository = parkingRepository;
    }

    @GetMapping("/{id}")
    public Horrodateur getHorrodateur(@PathVariable("id") long idPlace) {
        return horrodateurRepository.findByPlace(placeRepository.findById(idPlace));
    }

    @GetMapping("/bad/{id}")
    public List<Horrodateur> getAllBadHorrodateur(@PathVariable("id") long idParking){
        List<Place> places = parkingRepository.findById(idParking).getPlaces();
        List<Horrodateur> badHorrodateurs = new ArrayList<>();
        for (Place place:places) {
            Horrodateur horrodateur = horrodateurRepository.findByPlace(place);
            if(horrodateur != null && horrodateur.isBad()){
                badHorrodateurs.add(horrodateur);
            }
        }
        return badHorrodateurs;
    }
}
