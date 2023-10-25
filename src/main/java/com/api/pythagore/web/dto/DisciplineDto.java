package com.api.pythagore.web.dto;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisciplineDto {

    private String name;

    private String day;

    private int price;

    private LocalTime startTime;

    private LocalTime endTime;
}
