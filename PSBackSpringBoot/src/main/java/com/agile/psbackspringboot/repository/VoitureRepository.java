package com.agile.psbackspringboot.repository;

import com.agile.psbackspringboot.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, String> {
    Voiture findByPlaque(String Place);
    List<Voiture> findAll();
}
