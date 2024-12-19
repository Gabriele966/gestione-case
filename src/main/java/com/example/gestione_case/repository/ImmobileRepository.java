package com.example.gestione_case.repository;

import com.example.gestione_case.entity.Immobile;
import com.example.gestione_case.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmobileRepository extends JpaRepository<Immobile, Integer> {
}
