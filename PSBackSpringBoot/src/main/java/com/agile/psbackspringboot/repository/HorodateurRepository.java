package com.agile.psbackspringboot.repository;

import com.agile.psbackspringboot.model.Horodateur;
import com.agile.psbackspringboot.model.Place;
import com.agile.psbackspringboot.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorodateurRepository extends JpaRepository<Horodateur, Long> {
    Horodateur findById(long id);
    Horodateur findByPlace(Place place);
    Horodateur findByVoiture(Voiture voiture);
}
