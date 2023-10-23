package com.api.pythagore.domain.repository;

import com.api.pythagore.domain.entity.discipline.Discipline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends CrudRepository<Discipline, Long> {

}
