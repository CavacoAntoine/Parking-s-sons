package com.agile.psbackspringboot.repository;

import com.agile.psbackspringboot.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, String> {
    Personne findByEmail(String email);
}
