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
    public ImmobileDTO insert(@RequestBody ImmobileDTO immobileDTO){
        return immobileService.insert(immobileDTO);
    }

    @PutMapping("/update/{idImmobile}")
    public ImmobileDTO update(@RequestBody ImmobileDTO immobileDTO,@PathVariable("idImmobile") Integer id){
        return immobileService.update(immobileDTO,id);
    }

    @DeleteMapping("/delete/{idImmobile}")
    public ImmobileDTO  delete(@PathVariable("idImmobile") Integer id){
        return immobileService.delete(id);
    }

    @GetMapping("/contaImmobileConAnnesso")
    public String contaImmobileConAnnesso(@RequestParam String immobile, @RequestParam String annesso){
        return immobileService.countaImmobileConAnnesso(immobile,annesso);
    }

    @GetMapping("/anno/{anno}")
    public List<ImmobileDTO> getTramiteAnno(@PathVariable("anno") Integer anno){
        return immobileService.getTramiteAnno(anno);
    }
}
