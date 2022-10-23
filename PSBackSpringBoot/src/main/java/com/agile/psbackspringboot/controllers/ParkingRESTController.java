package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.creator.ParkingCreator;
import com.agile.psbackspringboot.enums.TypePlace;
import com.agile.psbackspringboot.message.ResponseMessage;
import com.agile.psbackspringboot.model.Parking;
import com.agile.psbackspringboot.model.Place;
import com.agile.psbackspringboot.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/parking")
public class ParkingRESTController {

    ParkingRepository parkingRepository;

    @Autowired
    public ParkingRESTController(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @GetMapping
    public List<Parking> getAllParkings() {
        return this.parkingRepository.findAll();
    }

    @GetMapping("/{id}/placelibre")
    public List<Place> getAllPlaceLibre(@PathVariable("id") long id) {
        Parking parking = this.parkingRepository.findById(id);
        List<Place> placesLibres = new ArrayList<>();
        for(TypePlace type : TypePlace.values()){
            placesLibres.addAll(parking.searchPlaceLibre(type));
        }
        return placesLibres;
    }

    @PostMapping
    public ResponseEntity<?> addParking(@RequestBody ParkingCreator parkingCreator) {
        if(this.parkingRepository.existsByNom(parkingCreator.getNom())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Parking déjà existant."), HttpStatus.BAD_REQUEST);
        }
        Parking parking = parkingCreator.create();
        this.parkingRepository.save(parking);
        return new ResponseEntity<>(parking, HttpStatus.CREATED);
    }

}
