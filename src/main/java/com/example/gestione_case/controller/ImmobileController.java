package com.example.gestione_case.controller;


import com.example.gestione_case.DTO.ImmobileDTO;
import com.example.gestione_case.entity.Immobile;
import com.example.gestione_case.service.ImmobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/Immobile")
public class ImmobileController {

    @Autowired
    ImmobileService immobileService;

    @GetMapping("/getAll")
    public List<ImmobileDTO> getAll(){
        return immobileService.getAll();
    }

    @GetMapping("/getById/{IdImmobile}")
    public ImmobileDTO getById(@PathVariable("IdImmobile") Integer id){
        return immobileService.getById(id);
    }

    @PostMapping("/insert")
    public Immobile insert(@RequestBody Immobile immobile){
        return immobileService.insert(immobile);
    }


}
