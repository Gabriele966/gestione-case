package com.example.gestione_case.repository;

import com.example.gestione_case.entity.Immobile;
import com.example.gestione_case.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImmobileRepository extends JpaRepository<Immobile, Integer> {

    @Query(value = "SELECT imm.tipo, an.tipo, COUNT(imm.tipo) FROM immobile as imm JOIN Proprietario pr ON pr.idP = imm.xidP JOIN Annessi an on an.XidI = imm.idI WHERE imm.tipo LIKE :immobile and an.tipo LIKE :annesso GROUP BY (imm.tipo, an.tipo);", nativeQuery = true )
    String contaAppartemtneiEAnnesso(@Param("immobile") String immobile, @Param("annesso") String annesso);

    @Query(value = "SELECT * FROM immobile WHERE imm.anno > :anno;", nativeQuery = true)
    List<Immobile> getTramiteAnno(@Param("anno") Integer anno);
}
