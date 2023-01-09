package com.api.pythagore.discipline;


import java.util.Optional;

public interface IDisciplineService {

    Discipline save(Discipline resa);

    Optional<Discipline> findById(long id);

    Iterable<Discipline> findAll();

    String deleteByID(long id);

    String delete(Discipline resa);

    Discipline update( Discipline resa);


}
