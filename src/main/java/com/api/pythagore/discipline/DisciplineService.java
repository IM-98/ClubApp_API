package com.api.pythagore.discipline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DisciplineService implements IDisciplineService{


    // Attention, il vaut mieux utiliser l'injection via constructeur (à corriger)
    @Autowired
    DisciplineRepository disciplineRepository;

    @Override
    public Discipline save(Discipline sport) {
        return disciplineRepository.save(sport);
    }

    @Override
    public Optional<Discipline> findById(long id) {
        return disciplineRepository.findById(id);
    }

    @Override
    public Iterable<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    @Override
    public String deleteByID(long id) {
         disciplineRepository.deleteById(id);
        return "discipline supprimé avec succès";
    }

    @Override
    public String delete(Discipline sport) {
        disciplineRepository.delete(sport);
        return "discipline supprimé avec succès";
    }

    @Override
    public Discipline update(Discipline newSport) {

        //vérifier la façon d'update avec JPA

        Optional<Discipline> sportToUpdate =  disciplineRepository.findById(newSport.getId());
        if (sportToUpdate.isEmpty())
            return null;

        Discipline sport = sportToUpdate.get();
        sport = newSport;
        disciplineRepository.save(sport);

        return sport;
    }
}
