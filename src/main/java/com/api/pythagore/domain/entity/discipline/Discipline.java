package com.api.pythagore.domain.entity.discipline;

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

    @Column(name = "discipline")
    private String discipline;

    @Column(name = "prix_annuel")
    private int price;

    @Column(name = "heure_debut")
    private LocalTime heureDebut;

    @Column(name = "heure_fin")
    private LocalTime heureFin;

    @Column(name = "date_creation")
    @CreatedDate
    private Instant createdDate;

    @Column(name = "date_modification")
    @LastModifiedDate
    private Instant updatedDate;



}