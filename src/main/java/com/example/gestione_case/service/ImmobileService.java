package com.example.gestione_case.service;

import com.example.gestione_case.DTO.ImmobileDTO;
import com.example.gestione_case.entity.Immobile;
import com.example.gestione_case.repository.ImmobileRepository;
import com.example.gestione_case.utils.ImmobileUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ImmobileService {

    @Autowired
    ImmobileRepository immobileRepository;

    @Transactional
     public List<ImmobileDTO> getAll(){
        List<Immobile> lImmobile = immobileRepository.findAll();
        List<ImmobileDTO> lImmobileDTO = new ArrayList<>();
        for(Immobile immobile : lImmobile){
            lImmobileDTO.add(ImmobileUtils.EntityToDTO(immobile));
        }
        return lImmobileDTO;
     }

    @Transactional
     public ImmobileDTO getById(Integer id){
         Optional<Immobile> immobile = immobileRepository.findById(id);
         if(immobile.isPresent()){
             return ImmobileUtils.EntityToDTO(immobile.get());
         }else{
             throw new EntityNotFoundException();
         }
     }

    @Transactional
     public ImmobileDTO insert(ImmobileDTO immobileDTO){
         Immobile immobile =  ImmobileUtils.DTOtoEntity(immobileDTO);
         Immobile imm = immobileRepository.save(immobile);
         ImmobileDTO immobileDTO1 = ImmobileUtils.EntityToDTO(imm);
         return immobileDTO1;
     }

    @Transactional
     public ImmobileDTO update(ImmobileDTO immobileDTO, Integer id){
         Optional<Immobile> immobile = immobileRepository.findById(id);
         if(immobile.isPresent()){
               immobileDTO.setIdImmobile(id);
               Immobile immob = immobileRepository.save(ImmobileUtils.DTOtoEntity(immobileDTO));
               return ImmobileUtils.EntityToDTO(immob);
         }else{
             throw new EntityNotFoundException();
         }
     }

    @Transactional
     public ImmobileDTO delete(Integer id){
         Optional<Immobile> immobile = immobileRepository.findById(id);
         if(immobile.isPresent()){
             for(int i = 0; i< immobile.get().getListaAnnessi().size(); i++){
                 if(immobile.get().getListaAnnessi().get(i).getImmobile().equals(immobile.get())){
                     immobile.get().getListaAnnessi().get(i).setImmobile(null);                 }
             }
             immobile.get().getListaAnnessi().clear();
             immobile.get().setProprietario(null);

             immobileRepository.delete(immobile.get());
             return ImmobileUtils.EntityToDTO(immobile.get());

         }else {
             throw new EntityNotFoundException();
         }
     }

     @Transactional
    public String countaImmobileConAnnesso(String immobile, String annesso){
        return immobileRepository.contaAppartemtneiEAnnesso(immobile, annesso);
     }

    @Transactional
    public List<ImmobileDTO> getTramiteAnno(Integer anno){
        List<Immobile> lImm = immobileRepository.getTramiteAnno(anno);
        List<ImmobileDTO> lImmobileDTO = new ArrayList<>();
        for(Immobile immobile : lImm){
            ImmobileDTO immobileDTO = new ImmobileDTO();
            immobileDTO.setIdImmobile(immobile.getIdi());
            immobileDTO.setTipo(immobile.getTipo());
            immobileDTO.setAnno(immobile.getAnno());
            lImmobileDTO.add(immobileDTO);
        }
        return lImmobileDTO;
    }

}
