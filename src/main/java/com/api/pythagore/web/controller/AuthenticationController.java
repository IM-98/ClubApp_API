package com.api.pythagore.web.controller;

import com.api.pythagore.web.dto.RegisterRequest;
import com.api.pythagore.domain.service.AuthenticationService;
import com.api.pythagore.web.dto.AuthenticationRequest;
import com.api.pythagore.web.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  // TODO : exception handler
  @PostMapping("/register")
  public String register(@RequestBody RegisterRequest request) {
      return authenticationService.register(request);
  }

  @GetMapping("/confirm-registration")
  public String confirmRegistration( @RequestParam("token") String token ){
      return authenticationService.confirmRegistration(token);
  }

  @PostMapping("/authenticate")
  public AuthenticationResponse authenticate(
      @RequestBody AuthenticationRequest request
  ) {
      return authenticationService.authenticate(request);
  }


}
