package com.api.pythagore.web.mapper;

import com.api.pythagore.domain.entity.discipline.Discipline;
import com.api.pythagore.web.dto.DisciplineDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplineMapper {

    DisciplineDto map(Discipline discipline);

    List<DisciplineDto> map(List<Discipline> disciplineList);


}
