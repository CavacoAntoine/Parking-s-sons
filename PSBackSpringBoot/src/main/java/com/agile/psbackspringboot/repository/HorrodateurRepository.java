package com.agile.psbackspringboot.repository;

import com.agile.psbackspringboot.model.Horrodateur;
import com.agile.psbackspringboot.model.Parking;
import com.agile.psbackspringboot.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorrodateurRepository extends JpaRepository<Horrodateur, Long> {
    Horrodateur findByPlace(Place place);
}
