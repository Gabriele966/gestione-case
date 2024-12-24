package com.example.gestione_case.repository;

import com.example.gestione_case.entity.Annessi;
import com.example.gestione_case.entity.Immobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnessiRepository extends JpaRepository<Annessi, Integer> {
    @Query(value = "SELECT tipo, COUNT(tipo) FROM Annessi WHERE tipo LIKE :tipo GROUP BY tipo;", nativeQuery = true)
    String countBox(@Param("tipo") String tipo);





}
