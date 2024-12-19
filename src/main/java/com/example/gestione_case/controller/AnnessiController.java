package com.example.gestione_case.controller;

import com.example.gestione_case.DTO.AnnessiDTO;
import com.example.gestione_case.service.AnnessiService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/annessi")
public class AnnessiController {

    @Autowired
    private AnnessiService annessiService;


    @GetMapping("/getAll")
    public List<AnnessiDTO> getAll(){
        return annessiService.getAll();
    }

    @GetMapping("/getById/{idAnnessi}")
    public AnnessiDTO getById(@PathVariable("idAnnessi") Integer id){
        return annessiService.getById(id);
    }

    @PostMapping("/insert")
    public AnnessiDTO insert(@RequestBody AnnessiDTO annessiDTO){
        return annessiService.insert(annessiDTO);
    }


    @PutMapping("/update/{idAnnessi}")
    public AnnessiDTO update(@RequestBody AnnessiDTO annessiDTO, @PathVariable("idAnnessi") Integer id){
        return annessiService.update(annessiDTO, id);
    }


    @DeleteMapping("/delete/{idAnnessi}")
    public AnnessiDTO delete(@PathVariable("idAnnessi") Integer id){
        return annessiService.delete(id);
    }
}
