package com.api.pythagore.web.dto;

import com.api.pythagore.domain.entity.club.Club;
import com.api.pythagore.domain.entity.discipline.Discipline;
import com.api.pythagore.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionDto {

    private Club club;

    private List<Discipline> disciplines;

    private User user;

    private BigDecimal annualPrice;

}

