package com.example.gestione_case.service;

import com.example.gestione_case.DTO.ImmobileDTO;
import com.example.gestione_case.entity.Immobile;
import com.example.gestione_case.repository.ImmobileRepository;
import com.example.gestione_case.utils.ImmobileUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ImmobileService {

    @Autowired
    ImmobileRepository immobileRepository;

     public List<ImmobileDTO> getAll(){
        List<Immobile> lImmobile = immobileRepository.findAll();
        List<ImmobileDTO> lImmobileDTO = new ArrayList<>();
        for(Immobile immobile : lImmobile){
            lImmobileDTO.add(ImmobileUtils.EntityToDTO(immobile));
        }
        return lImmobileDTO;
     }

     public ImmobileDTO getById(Integer id){
         Optional<Immobile> immobile = immobileRepository.findById(id);
         if(immobile.isPresent()){
             return ImmobileUtils.EntityToDTO(immobile.get());
         }else{
             throw new EntityNotFoundException();
         }
     }

     public Immobile insert(Immobile immobile){
         Immobile immobile1 = immobileRepository.save(immobile);
         return immobile1;
     }




}
