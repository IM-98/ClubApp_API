package com.api.pythagore.domain.entity.discipline;

import com.api.pythagore.domain.enums.DayOfTheWeek;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Discipline {
    @SequenceGenerator(
            name = "discipline_sequence",
            sequenceName = "discipline_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "discipline_sequence"
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "annual_price")
    private int price;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "day")
    @Enumerated(EnumType.STRING)
    private DayOfTheWeek day;

    @Column(name = "creation_date")
    @CreatedDate
    private Instant createdDate;

    @Column(name = "updated_date")
    @LastModifiedDate
    private Instant updatedDate;



}