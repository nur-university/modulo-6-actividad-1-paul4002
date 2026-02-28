package com.example.api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_gateway.dto.LoginRequest;
import com.example.api_gateway.service.KeyCloakClientService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class AuthController {

  @Autowired
  private KeyCloakClientService keyCloakClientService;

  @PostMapping("/login")
  public Mono<ResponseEntity<?>> login(@RequestBody LoginRequest request) {
    return keyCloakClientService.login(request.username, request.password).map(ResponseEntity::ok);
  }
}
