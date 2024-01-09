package com.api.pythagore.mapper;

import com.api.pythagore.domain.entity.discipline.Discipline;
import com.api.pythagore.web.dto.DisciplineDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplineMapper {

    DisciplineDto map(Discipline discipline);

    Discipline map(DisciplineDto dto);

    List<DisciplineDto> map(List<Discipline> disciplineList);


}
