package com.example.gestione_case.utils;

import com.example.gestione_case.DTO.AnnessiDTO;
import com.example.gestione_case.entity.Annessi;
import com.example.gestione_case.entity.Immobile;

public class AnnessiUtils {

    public static AnnessiDTO EntitytoDTO(Annessi annessi){
        AnnessiDTO annessiDTO = new AnnessiDTO();
        annessiDTO.setId(annessi.getId());
        if(annessi.getImmobile() == null){
            annessiDTO.setidImmobile(0);
        }else{
            annessiDTO.setidImmobile(annessi.getImmobile().getIdi());
        }

        annessiDTO.setTipo(annessi.getTipo());
        annessiDTO.setSup(annessi.getSup());
        return annessiDTO;
    }


    public static Annessi DTOtoEntity(AnnessiDTO annessiDTO){
        Annessi annessi = new Annessi();
        Immobile immobile = new Immobile();
        immobile.setIdi(annessiDTO.getidImmobile());
        annessi.setId(annessiDTO.getId());
        annessi.setImmobile(immobile);
        annessi.setTipo(annessiDTO.getTipo());
        annessi.setSup(annessiDTO.getSup());
        return annessi;
    }
}
