package com.api.pythagore.web.controller;

import com.api.pythagore.web.dto.RegisterRequest;
import com.api.pythagore.domain.service.auth.AuthenticationService;
import com.api.pythagore.web.dto.AuthenticationRequest;
import com.api.pythagore.web.dto.AuthenticationResponse;
import com.api.pythagore.web.dto.RegistrationToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Value("${aws.s3Url}")
    private String s3Url;

    // TODO : exception handler pour les erreur auth car Spring security les cast en 403
    @PostMapping("/register")
    public RegistrationToken register(@RequestBody RegisterRequest request) {
        String token = authenticationService.register(request);
        return new RegistrationToken(token);
    }

    //TODO : variable d'environnement pour l'url de la page d'acceuil
    @GetMapping("/confirm")
    public RedirectView confirmRegistration(@RequestParam("token") String token) {
        authenticationService.confirmRegistration(token);
        return new RedirectView(s3Url);
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        try {
            return authenticationService.authenticate(request);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }


}
