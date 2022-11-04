package com.agile.psbackspringboot.repository;

import com.agile.psbackspringboot.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findById(long idPlace);
}