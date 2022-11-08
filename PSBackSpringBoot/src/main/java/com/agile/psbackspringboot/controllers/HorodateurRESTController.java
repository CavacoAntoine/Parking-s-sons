package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.model.Horodateur;
import com.agile.psbackspringboot.model.Place;
import com.agile.psbackspringboot.repository.HorodateurRepository;
import com.agile.psbackspringboot.repository.ParkingRepository;
import com.agile.psbackspringboot.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/horodateur")
public class HorodateurRESTController {

    HorodateurRepository horodateurRepository;
    PlaceRepository placeRepository;
    ParkingRepository parkingRepository;

    @Autowired
    public HorodateurRESTController(HorodateurRepository horodateurRepository, PlaceRepository placeRepository, ParkingRepository parkingRepository) {
        this.horodateurRepository = horodateurRepository;
        this.placeRepository = placeRepository;
        this.parkingRepository = parkingRepository;
    }

    @GetMapping("/{id}")
    public Horodateur getHorodateurById(@PathVariable("id") long id) {
        return horodateurRepository.findById(id);
    }

    @GetMapping("/bad/{id}")
    public List<Horodateur> getAllBadHorodateur(@PathVariable("id") long idParking){
        List<Place> places = parkingRepository.findById(idParking).getPlaces();
        List<Horodateur> badHorodateurs = new ArrayList<>();
        for (Place place:places) {
            Horodateur horodateur = horodateurRepository.findByPlace(place);
            if(horodateur != null && horodateur.isBad()){
                badHorodateurs.add(horodateur);
            }
        }
        return badHorodateurs;
    }
}
