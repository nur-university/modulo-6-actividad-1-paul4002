package com.example.api_gateway.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.api_gateway.dto.TokenResponse;

import reactor.core.publisher.Mono;

@Service
public class KeyCloakClientService {

  @Value("${keycloak.server-url}")
  private String serverUrl;

  @Value("${keycloak.realm}")
  private String realm;

  @Value("${keycloak.client-id}")
  private String clientId;

  @Value("${keycloak.client-secret}")
  private String clientSecret;

  private final WebClient webClient;

  public KeyCloakClientService(WebClient.Builder builder) {
    this.webClient = builder.build();
  }

  public Mono<TokenResponse> login(String username, String password) {
    return webClient.post()
      .uri(serverUrl + "/realms/" + realm + "/protocol/openid-connect/token")
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
      .body(BodyInserters
              .fromFormData("grant_type", "password")
              .with("client_id", clientId)
              .with("client_secret", clientSecret)
              .with("username", username)
              .with("password", password))
      .retrieve()
      .onStatus(
        status -> status.value() == 401,
        response -> Mono.error(new RuntimeException("error.credenciales"))
      )
      .onStatus(
        HttpStatusCode::isError,
        response -> Mono.error(new RuntimeException("error.auth"))
      )
      .bodyToMono(TokenResponse.class);
  }
}
