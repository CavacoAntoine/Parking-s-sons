package com.agile.psbackspringboot.repository;

import com.agile.psbackspringboot.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    Parking findById(long id);
    boolean existsByNom(String nom);
    Parking findByPlaces_Id(long id);

    @Query("""
            select (count(p) > 0) from Parking p
            where p.adresse.numero = :numero and p.adresse.rue = :rue and p.adresse.ville = :ville and p.adresse.codePostal = :codePostal""")
    boolean existsByAdresse(@Param("numero") int numero, @Param("rue") String rue, @Param("ville") String ville, @Param("codePostal") int codePostal);





}
