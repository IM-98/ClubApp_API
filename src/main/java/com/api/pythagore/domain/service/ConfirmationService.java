package com.api.pythagore.domain.service;

import com.api.pythagore.domain.entity.confirmation.Confirmation;
import com.api.pythagore.domain.repository.ConfirmationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmationService {
    private final ConfirmationRepository confirmationRepository;

    public void saveConfirmationUuid(Confirmation confirmation){

    }
}
