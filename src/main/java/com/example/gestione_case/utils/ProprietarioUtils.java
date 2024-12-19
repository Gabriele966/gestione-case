package com.example.gestione_case.utils;

import com.example.gestione_case.DTO.ImmobileDTO;
import com.example.gestione_case.DTO.ProprietarioDTO;
import com.example.gestione_case.entity.Immobile;
import com.example.gestione_case.entity.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class ProprietarioUtils {

    public static ProprietarioDTO entityToDTO(Proprietario proprietario) {
        List<ImmobileDTO> lImmobileDTO = new ArrayList<>();
        ProprietarioDTO proprietarioDTO = new ProprietarioDTO();
        proprietarioDTO.setIdProprietario(proprietario.getIdP());
        proprietarioDTO.setNome(proprietario.getNome());
        proprietarioDTO.setCognome(proprietario.getCognome());
        for(int i = 0; i < proprietario.getListaImmobili().size(); i++){
            ImmobileDTO immobileDTO = ImmobileUtils.EntityToDTO(proprietario.getListaImmobili().get(i));
            lImmobileDTO.add(immobileDTO);
        }
        proprietarioDTO.setImmobileDTOList(lImmobileDTO);
        return proprietarioDTO;
    }

    public static Proprietario DTOToEntity(ProprietarioDTO proprietarioDTO) {
        List<Immobile> lImmobile = new ArrayList<>();
        Proprietario proprietario = new Proprietario();
        proprietario.setIdP(proprietarioDTO.getIdProprietario());
        proprietario.setNome(proprietarioDTO.getNome());
        proprietario.setCognome(proprietarioDTO.getCognome());
        for(int i = 0; i < proprietarioDTO.getImmobileDTOList().size(); i++){
            Immobile immobile = new Immobile();
            immobile = ImmobileUtils.DTOtoEntity(proprietarioDTO.getImmobileDTOList().get(i));
            lImmobile.add(immobile);
        }
        proprietario.setListaImmobili(lImmobile);
        return proprietario;
    }
}
