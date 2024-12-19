package com.example.gestione_case.utils;

import com.example.gestione_case.DTO.AnnessiDTO;
import com.example.gestione_case.DTO.ImmobileDTO;
import com.example.gestione_case.entity.Annessi;
import com.example.gestione_case.entity.Immobile;
import com.example.gestione_case.entity.Proprietario;
import com.example.gestione_case.service.AnnessiService;

import java.util.ArrayList;
import java.util.List;

public class ImmobileUtils {
    AnnessiService annessiService;

    public static ImmobileDTO EntityToDTO(Immobile immobile) {
        List<AnnessiDTO> lAnessiDTO = new ArrayList<>();
        ImmobileDTO immobileDTO = new ImmobileDTO();
        immobileDTO.setIdImmobile(immobile.getIdImmobile());
        if (immobile.getProprietario() == null){
            immobileDTO.setIdProprietario(null);
        }else{
            immobileDTO.setIdProprietario(immobile.getProprietario().getIdP());
        }
        immobileDTO.setTipo(immobile.getTipo());
        immobileDTO.setVani(immobile.getVani());
        immobileDTO.setCosto(immobile.getCosto());
        immobileDTO.setSuperfice(immobile.getSuperfice());
        immobileDTO.setAnno(immobile.getAnno());
        for(int i = 0; i < immobile.getListaAnnessi().size(); i++){
            AnnessiDTO oAnnessiDTO = AnnessiUtils.EntitytoDTO(immobile.getListaAnnessi().get(i));
            lAnessiDTO.add(oAnnessiDTO);
        }
        immobileDTO.setListaAnnessi(lAnessiDTO);
        return immobileDTO;
    }


    public static Immobile DTOtoEntity(ImmobileDTO immobileDTO) {
        List<Annessi> lAnnessi = new ArrayList<>();
        Proprietario oProprietario = new Proprietario();
        oProprietario.setIdP(immobileDTO.getIdProprietario());
        Immobile immobile = new Immobile();
        immobile.setIdImmobile(immobileDTO.getIdImmobile());
        immobile.setProprietario(oProprietario);
        immobile.setTipo(immobileDTO.getTipo());
        immobile.setVani(immobileDTO.getVani());
        immobile.setCosto(immobileDTO.getCosto());
        immobile.setSuperfice(immobileDTO.getSuperfice());
        immobile.setAnno(immobileDTO.getAnno());
        for(int i = 0; i < immobileDTO.getListaAnnessi().size(); i++){
            Annessi annessi = AnnessiUtils.DTOtoEntity(immobileDTO.getListaAnnessi().get(i));
            lAnnessi.add(annessi);
        }
        immobile.setListaAnnessi(lAnnessi);
        return immobile;
    }


    public static Immobile DTOtoEntityPerInsert(ImmobileDTO immobileDTO) {
        List<Annessi> lAnnessi = new ArrayList<>();
        Proprietario oProprietario = new Proprietario();
        oProprietario.setIdP(immobileDTO.getIdProprietario());
        Immobile immobile = new Immobile();
        immobile.setProprietario(oProprietario);
        immobile.setTipo(immobileDTO.getTipo());
        immobile.setVani(immobileDTO.getVani());
        immobile.setCosto(immobileDTO.getCosto());
        immobile.setSuperfice(immobileDTO.getSuperfice());
        immobile.setAnno(immobileDTO.getAnno());
        for(int i = 0; i < immobileDTO.getListaAnnessi().size(); i++){
            Annessi annessi = AnnessiUtils.DTOtoEntity(immobileDTO.getListaAnnessi().get(i));
            lAnnessi.add(annessi);
        }
        immobile.setListaAnnessi(lAnnessi);
        return immobile;
    }
}
