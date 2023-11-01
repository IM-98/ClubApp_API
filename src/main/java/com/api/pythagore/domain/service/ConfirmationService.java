package com.api.pythagore.domain.service;

import com.api.pythagore.domain.entity.confirmation.Confirmation;
import com.api.pythagore.domain.entity.user.User;
import com.api.pythagore.domain.repository.ConfirmationRepository;
import com.api.pythagore.domain.repository.UserRepository;
import com.api.pythagore.web.exception.BadRequestException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfirmationService {
    private final ConfirmationRepository confirmationRepository;
    private final UserRepository userRepository;

    public void saveConfirmation(Confirmation confirmation){
        confirmationRepository.save(confirmation);
    }

    @Transactional
    public String confirmToken(String token) {
        Confirmation confirmation = confirmationRepository
                .findByUuid(token)
                .orElseThrow(()-> new BadRequestException("Aucune confirmation en attente trouvée"));
        if(confirmation.getConfirmedAt() != null){
            throw new BadRequestException("Ce compte est déjà vérifié");
        }

        if(confirmation.getExpirationDate().isBefore(LocalDateTime.now())){
            throw new BadRequestException("Votre lien de confirmation a expiré");
        }

        confirmation.setConfirmedAt(LocalDateTime.now());
        confirmationRepository.save(confirmation);

        User userToConfirm = userRepository
                .findByEmail(confirmation.getUser().getEmail())
                .orElseThrow(()-> new BadRequestException("Aucun utilisateur en attente de confirmation correspondant"));

        userToConfirm.setEnabled(true);
        userRepository.save(userToConfirm);
        log.info("user enabled");

        return token;
    }
}
