package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.comparator.ParkingSortByName;
import com.agile.psbackspringboot.comparator.PlaceSortByType;
import com.agile.psbackspringboot.creator.ParkingFactory;
import com.agile.psbackspringboot.enums.TypeCar;
import com.agile.psbackspringboot.message.ResponseMessage;
import com.agile.psbackspringboot.model.Horodateur;
import com.agile.psbackspringboot.model.Parking;
import com.agile.psbackspringboot.model.Place;
import com.agile.psbackspringboot.repository.HorodateurRepository;
import com.agile.psbackspringboot.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/parking")
public class ParkingRESTController {

    ParkingRepository parkingRepository;
    HorodateurRepository horodateurRepository;

    @Autowired
    public ParkingRESTController(ParkingRepository parkingRepository, HorodateurRepository horodateurRepository) {
        this.parkingRepository = parkingRepository;
        this.horodateurRepository = horodateurRepository;
    }

    @GetMapping
    public List<Parking> getAllParkings() {
        List<Parking> parkings = this.parkingRepository.findAll();
        parkings.sort(new ParkingSortByName());
        return parkings;
    }

    @GetMapping("/bad")
    public List<Parking> getAllBadParkings() {
        List<Parking> parkings = this.parkingRepository.findAll();
        List<Parking> badParkings = new ArrayList<>();
        for(Parking parking : parkings) {
            List<Place> places = parking.getPlaces();
            for (Place place:places) {
                Horodateur horodateur = horodateurRepository.findByPlace(place);
                if(horodateur != null && horodateur.isBad()){
                    badParkings.add(parking);
                    break;
                }
            }
        }
        badParkings.sort(new ParkingSortByName());
        return badParkings;
    }

    @GetMapping("/libres")
    public List<Parking> getParkingsLibres() {
        return this.parkingRepository.findAll().stream().filter(parking ->
                parking.getPlaces().stream().filter(Place::isLibre).toList().size() > 0).sorted(new ParkingSortByName()).toList();
    }

    @GetMapping("/complets")
    public List<Parking> getParkingsComplets() {
        return this.parkingRepository.findAll().stream().filter(parking ->
                parking.getPlaces().stream().filter(Place::isLibre).toList().size() == 0).sorted(new ParkingSortByName()).toList();
    }

    @GetMapping("/{id}")
    public Parking getParkingById(@PathVariable("id") long id) {
        return this.parkingRepository.findById(id);
    }

    @GetMapping("/{id}/placelibre")
    public List<Place> getAllPlaceLibre(@PathVariable("id") long id) {
        Parking parking = this.parkingRepository.findById(id);
        List<Place> placesLibres = new ArrayList<>();
        for (TypeCar type : TypeCar.values()) {
            placesLibres.addAll(parking.searchPlaceLibre(type));
        }
        placesLibres.sort(new PlaceSortByType());
        return placesLibres;
    }

    @PostMapping
    public ResponseEntity<?> addParking(@RequestBody ParkingFactory parkingFactory) {
        Parking parking = parkingFactory.create();

        if (this.parkingRepository.existsByNom(parking.getNom())) {
            return new ResponseEntity<>(new ResponseMessage("nom"), HttpStatus.BAD_REQUEST);
        }

        if (this.parkingRepository.existsByAdresse(parking.getAdresse().getNumero(),
                parking.getAdresse().getRue(),
                parking.getAdresse().getVille(),
                parking.getAdresse().getCodePostal())) {
            return new ResponseEntity<>(new ResponseMessage("adresse"), HttpStatus.BAD_REQUEST);
        }

        this.parkingRepository.save(parking);
        return new ResponseEntity<>(parking, HttpStatus.CREATED);
    }

}
