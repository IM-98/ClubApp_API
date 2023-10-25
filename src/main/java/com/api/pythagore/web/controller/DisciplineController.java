package com.api.pythagore.web.controller;


import com.api.pythagore.domain.entity.discipline.Discipline;
import com.api.pythagore.domain.service.DisciplineService;
import com.api.pythagore.web.dto.DisciplineDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/discipline")
@RequiredArgsConstructor
@Slf4j
public class DisciplineController {

    private final DisciplineService disciplineService;

    @PostMapping(path = "/create")
    public Discipline PostDiscipline(@RequestBody Discipline disciplineEntity) {
        return disciplineService.save(disciplineEntity);
    }

    @GetMapping(path = "/get")
    public Optional<Discipline> GetDiscipline(@RequestParam Long id) {
        return disciplineService.findById(id);
    }

    @GetMapping(path = "/get-all")
    public List<DisciplineDto> GetAllDiscipline() {
        log.info("endpoint");
        return disciplineService.findAll();
    }


}
