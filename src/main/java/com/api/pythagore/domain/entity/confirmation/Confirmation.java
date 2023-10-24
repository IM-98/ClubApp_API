package com.api.pythagore.domain.entity.confirmation;

import com.api.pythagore.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
    private String id;

    @Column(name = "confirmation_token", nullable = false)
    private String uuid;

    @Column(name = "date_creation", nullable = false)
    @CreatedDate
    private Instant createdDate;

    @Column(name = "date_expiration", nullable = false)
    private Instant expirationDate;

    @Column(name = "date_confirmation")
    private Instant confirmedAt;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;



}
