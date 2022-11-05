package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.model.Personne;
import com.agile.psbackspringboot.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/personne")
public class PersonneRESTController {

    VoitureRepository voitureRepository;

    @Autowired
    public PersonneRESTController(VoitureRepository voitureRepository){
        this.voitureRepository = voitureRepository;
    }

    public Personne getPersonneFormPlaque(@PathVariable("plaque")String plaque){
        return voitureRepository.findByPlaque(plaque).getProprietaire();
    }
}
