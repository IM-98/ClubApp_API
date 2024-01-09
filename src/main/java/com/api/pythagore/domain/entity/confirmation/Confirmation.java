package com.api.pythagore.domain.entity.confirmation;

import com.api.pythagore.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Confirmation {

    @SequenceGenerator(
            name = "confirmation_sequence",
            sequenceName = "confirmation_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_sequence"
    )
    @Column(name = "confirmation_id")
    private Long id;

    @Column(name = "confirmation_token", nullable = false)
    private String uuid;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "date_expiration", nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "date_confirmation")
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;



}
