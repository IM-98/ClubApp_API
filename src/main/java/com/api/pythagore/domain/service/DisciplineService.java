package com.api.pythagore.domain.service;

import com.api.pythagore.domain.entity.discipline.Discipline;
import com.api.pythagore.domain.repository.DisciplineRepository;
import com.api.pythagore.web.dto.DisciplineDto;
import com.api.pythagore.web.mapper.DisciplineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DisciplineService {

    private final DisciplineMapper disciplineMapper;

    private final DisciplineRepository disciplineRepository;

    public Discipline save(Discipline sport) {
        return disciplineRepository.save(sport);
    }

    
    public Optional<Discipline> findById(long id) {
        return disciplineRepository.findById(id);
    }

    
    public List<DisciplineDto> findAll() {
        return disciplineMapper.map(disciplineRepository.findAll());
    }

    
    public String deleteByID(long id) {
         disciplineRepository.deleteById(id);
        return "discipline supprimé avec succès";
    }

    
    public String delete(Discipline sport) {
        disciplineRepository.delete(sport);
        return "discipline supprimé avec succès";
    }


}
