package com.api.pythagore.controller;


import com.api.pythagore.discipline.Discipline;
import com.api.pythagore.discipline.IDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/discipline")
public class DisciplineController {

    @Autowired
    IDisciplineService iDisciplineService;

    @PostMapping(path="/create")
    public Discipline PostDiscipline (@RequestBody Discipline discipline ){
        return iDisciplineService.save(discipline);
    }

    @GetMapping(path = "/get")
    public Optional<Discipline> GetDiscipline(@RequestParam Long id){
        return iDisciplineService.findById(id);
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping(path = "/getAll")
    public Iterable<Discipline> GetAllDiscipline(){
        System.out.println("endpoint touché");
            return iDisciplineService.findAll();
    }


}
