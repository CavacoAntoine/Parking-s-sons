package com.agile.psbackspringboot.repository;

import com.agile.psbackspringboot.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    Parking findById(long id);
    boolean existsByNom(String nom);
}
