package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.model.Parking;
import com.agile.psbackspringboot.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
