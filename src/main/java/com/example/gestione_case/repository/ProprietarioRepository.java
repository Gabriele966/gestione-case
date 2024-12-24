package com.example.gestione_case.repository;

import com.example.gestione_case.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {
    //prova a fare la mappa e mettere l'idp
    @Query(value = "SELECT pr.idP, pr.Nome, pr.Cognome, SUM(imm.Sup) FROM Proprietario AS pr JOIN immobile imm ON imm.xidP = pr.idP GROUP BY pr.idP, pr.Nome, pr.Cognome", nativeQuery = true)
    public List<Object> getMetriProprietario();


    // funziona va sistemato che parte la lista infinita
    @Query(value = "SELECT pr.idp, pr.Nome, pr.Cognome, imm.tipo FROM Proprietario AS pr JOIN immobile imm ON imm.xidP = pr.idP WHERE imm.tipo LIKE :immobile", nativeQuery = true)
    public List<Proprietario> getProprietarioSpecificoImmobile(@Param("immobile") String immobile);

    @Query(value = "SELECT pr.idP, pr.Nome, pr.Cognome, SUM(imm.Vani) FROM Proprietario AS pr JOIN immobile imm ON imm.xidP = pr.idP GROUP BY pr.idP, pr.Nome, pr.Cognome", nativeQuery = true)
    public List<Object> numeroVani();
}
