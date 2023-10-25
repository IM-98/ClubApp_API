package com.api.pythagore.web.controller;

import com.api.pythagore.web.dto.RegisterRequest;
import com.api.pythagore.domain.service.AuthenticationService;
import com.api.pythagore.web.dto.AuthenticationRequest;
import com.api.pythagore.web.dto.AuthenticationResponse;
import com.api.pythagore.web.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

  private final AuthenticationService service;

  // TODO : exception handler
  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
      return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
      return ResponseEntity.ok(service.authenticate(request));
  }


}
