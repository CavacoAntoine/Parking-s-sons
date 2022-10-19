package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.message.ResponseMessage;
import com.agile.psbackspringboot.model.Parking;
import com.agile.psbackspringboot.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> addParking(@RequestBody Parking parking) {
        if(this.parkingRepository.existsByNom(parking.getNom())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Parking déjà existant."), HttpStatus.BAD_REQUEST);
        }
        this.parkingRepository.save(parking);
        return new ResponseEntity<>(parking, HttpStatus.CREATED);
    }

}
