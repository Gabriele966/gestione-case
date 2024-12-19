package com.example.gestione_case.service;

import com.example.gestione_case.DTO.AnnessiDTO;
import com.example.gestione_case.entity.Annessi;
import com.example.gestione_case.repository.AnnessiRepository;
import com.example.gestione_case.utils.AnnessiUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnessiService {

    @Autowired
    private AnnessiRepository annessiRepository;

    public List<AnnessiDTO> getAll(){
        annessiRepository.findAll();
        List<AnnessiDTO> lAnnessiDTO = new ArrayList<>();
        for(Annessi annessi : annessiRepository.findAll()){
            lAnnessiDTO.add(AnnessiUtils.EntitytoDTO(annessi));
        }
        return lAnnessiDTO;
    }

    public AnnessiDTO getById(Integer id){
        Optional<Annessi> annessi = annessiRepository.findById(id);
        if(annessi.isPresent()){
            return AnnessiUtils.EntitytoDTO(annessi.get());
        }else{
            throw new EntityNotFoundException();
        }
    }

    public AnnessiDTO insert(AnnessiDTO annessiDTO){
        Annessi annessi = AnnessiUtils.DTOtoEntity(annessiDTO);
        annessiRepository.save(annessi);
        return AnnessiUtils.EntitytoDTO(annessi);
    }


    public AnnessiDTO update(AnnessiDTO annessiDTO, Integer id){
        Optional<Annessi> annessi = annessiRepository.findById(id);
        if(annessi.isPresent()){
            annessiDTO.setId(id);
            Annessi ann = AnnessiUtils.DTOtoEntity(annessiDTO);
            annessiRepository.save(ann);
            return AnnessiUtils.EntitytoDTO(ann);
        }else{
            throw new EntityNotFoundException();
        }
    }


    public AnnessiDTO delete(Integer id){
        Optional<Annessi> annessi = annessiRepository.findById(id);
        if(annessi.isPresent()){
            Annessi ann = annessi.get();
            annessi.get().getImmobile().getListaAnnessi().remove(ann);
            annessiRepository.deleteById(id);
            return AnnessiUtils.EntitytoDTO(ann);
        }else{
            throw new EntityNotFoundException("Annesso già eliminato");
        }
    }

}
