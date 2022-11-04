package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.model.Horrodateur;
import com.agile.psbackspringboot.model.Place;
import com.agile.psbackspringboot.repository.HorrodateurRepository;
import com.agile.psbackspringboot.repository.ParkingRepository;
import com.agile.psbackspringboot.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/horrodateur")
public class HorrodateurRESTController {

    HorrodateurRepository horrodateurRepository;
    PlaceRepository placeRepository;

    @Autowired
    public HorrodateurRESTController(HorrodateurRepository horrodateurRepository, PlaceRepository placeRepository) {
        this.horrodateurRepository = horrodateurRepository;
        this.placeRepository = placeRepository;
    }

    @GetMapping("/{id}")
    public Horrodateur getHorrodateur(@PathVariable("id") long idPlace) {
        return horrodateurRepository.findByPlace(placeRepository.findById(idPlace));
    }
}
