package com.example.gestione_case.repository;

import com.example.gestione_case.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {
}
