package com.example.gestione_case.controller;

import com.example.gestione_case.DTO.ProprietarioDTO;
import com.example.gestione_case.entity.Proprietario;
import com.example.gestione_case.service.ProprietarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {

    public final ProprietarioService proprietarioService;

    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;
    }

    @GetMapping("/getAll")
    public List<ProprietarioDTO> getAll(){
        return proprietarioService.getAll();
    }

    @GetMapping("/findById/{idProprietario}")
    public ProprietarioDTO findById(@PathVariable("idProprietario") Integer idProprietario){
        return proprietarioService.getProprietarioById(idProprietario);
    }

    @DeleteMapping("/delete/{idPropietario}")
    public ProprietarioDTO deleteById(@PathVariable("idPropietario") Integer idProprietario){
        return proprietarioService.delete(idProprietario);
    }

    @PostMapping("/insert")
    public ProprietarioDTO insert(@RequestBody ProprietarioDTO proprietarioDTO){
       return proprietarioService.insert(proprietarioDTO);
    }

    @PutMapping("/update/{idProprietario}")
    public ProprietarioDTO update(@PathVariable("idProprietario") Integer idProprietario, @RequestBody ProprietarioDTO proprietarioDTO ){
        return proprietarioService.update(idProprietario, proprietarioDTO);
    }



}
