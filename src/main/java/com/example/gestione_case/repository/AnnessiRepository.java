package com.example.gestione_case.repository;

import com.example.gestione_case.entity.Annessi;
import com.example.gestione_case.entity.Immobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnessiRepository extends JpaRepository<Annessi, Integer> {
}
