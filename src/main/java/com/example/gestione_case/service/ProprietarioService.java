package com.example.gestione_case.service;

import com.example.gestione_case.DTO.ProprietarioDTO;
import com.example.gestione_case.entity.Proprietario;
import com.example.gestione_case.repository.ProprietarioRepository;
import com.example.gestione_case.utils.ProprietarioUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProprietarioService {


    public final ProprietarioRepository proprietarioRepository;

    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    @Transactional
    public List<ProprietarioDTO> getAll(){
        List<Proprietario> lProprietario = proprietarioRepository.findAll();
        List<ProprietarioDTO> lProprietarioDTO = new ArrayList<>();
        ProprietarioUtils UtilsProprietario = new ProprietarioUtils();
        for(Proprietario proprietario : lProprietario){
            ProprietarioDTO proprietarioDTO = UtilsProprietario.entityToDTO(proprietario);
            lProprietarioDTO.add(proprietarioDTO);
        }
        return lProprietarioDTO;
    }

    @Transactional
    public ProprietarioDTO getProprietarioById(Integer  idProprietario){
        Optional<Proprietario> proprietario = proprietarioRepository.findById(idProprietario);
        if(proprietario.isPresent()){
            ProprietarioDTO proprietarioDTO = ProprietarioUtils.entityToDTO(proprietario.get());
            return proprietarioDTO;
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public ProprietarioDTO delete(Integer idProprietario){
        Optional<Proprietario> proprietario = proprietarioRepository.findById(idProprietario);
        if(proprietario.isPresent()){
            for(int i = 0; i < proprietario.get().getListaImmobili().size(); i++){
                proprietario.get().getListaImmobili().get(i).setProprietario(null);
            }
            proprietario.get().getListaImmobili().clear();
            ProprietarioDTO proprietarioDTO = new ProprietarioDTO();
            proprietarioDTO.setIdProprietario(idProprietario);
            proprietarioDTO.setNome(proprietario.get().getNome());
            proprietarioDTO.setCognome(proprietario.get().getCognome());
            proprietarioRepository.delete(proprietario.get());
            return proprietarioDTO;
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public ProprietarioDTO insert(ProprietarioDTO proprietarioDTO){
        Proprietario proprietario = ProprietarioUtils.DTOToEntity(proprietarioDTO);
        proprietarioRepository.save(proprietario);
        ProprietarioDTO savedProprietarioDTO = ProprietarioUtils.entityToDTO(proprietario);
        return savedProprietarioDTO;
    }

    @Transactional
    public ProprietarioDTO update (Integer idProprietario, ProprietarioDTO proprietarioDTO){
        Optional<Proprietario> proprietario = proprietarioRepository.findById(idProprietario);
        if(proprietario.isPresent()){
            proprietarioDTO.setIdProprietario(idProprietario);
            Proprietario prop = ProprietarioUtils.DTOToEntity(proprietarioDTO);
            proprietarioRepository.save(prop);
            return ProprietarioUtils.entityToDTO(proprietario.get());
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public  List<Object> getMetriProprietario(){
        List<Object> lProp = proprietarioRepository.getMetriProprietario();
        return lProp;
    }

    @Transactional
    public List<ProprietarioDTO> getProprietarioSpecificoImmobile(String immobile){
        List<Proprietario> lProp = proprietarioRepository.getProprietarioSpecificoImmobile(immobile);
        List<ProprietarioDTO> lProprietarioDTO = new ArrayList<>();
        for(Proprietario proprietario : lProp){
            ProprietarioDTO propDTO = new ProprietarioDTO();
            propDTO.setIdProprietario(proprietario.getIdP());
            propDTO.setNome(proprietario.getNome());
            propDTO.setCognome(proprietario.getCognome());
            lProprietarioDTO.add(propDTO);
        }
        return lProprietarioDTO;
    }

    @Transactional
    public  List<Object> numeroVani(){
        List<Object> lProp = proprietarioRepository.numeroVani();
        return lProp;
    }


}

