package com.api.pythagore.domain.entity.discipline;

import com.api.pythagore.domain.entity.club.Club;
import com.api.pythagore.domain.enums.DayOfTheWeek;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;

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
    @Column(name = "discipline_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "annual_price", precision = 8, scale = 2)
    private BigDecimal price;

    @ManyToMany(mappedBy = "disciplines")
    private List<Club> clubs;

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