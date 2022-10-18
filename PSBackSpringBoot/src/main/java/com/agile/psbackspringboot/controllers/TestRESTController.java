package com.agile.psbackspringboot.controllers;

import com.agile.psbackspringboot.model.Personne;
import com.agile.psbackspringboot.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/personne")
public class TestRESTController {

    PersonneRepository personneRepository;

    @Autowired
    public TestRESTController(PersonneRepository personneRepository){
        this.personneRepository = personneRepository;
    }

    @GetMapping()
    public String test(){
        Personne moi = this.personneRepository.findByEmail("antoinecavaco@gmail.com");
        String res = "<html>\n  <head>\n</head>\n   <body>\n";
        res+= " email = " + moi.getEmail() +"</br>";
        res+= " nom = "+moi.getNom()+"</br>";
        res+= " prenom = "+moi.getPrenom()+"</br>";
        res+= " age = "+moi.getAge();
        return res + "\n  </body>\n</html>";
    }

    @GetMapping("/{email}")
    public Personne getPersonneByEmail(@PathVariable("email") String email){
        Personne personne = this.personneRepository.findByEmail(email);
        return personne;
    }
}
