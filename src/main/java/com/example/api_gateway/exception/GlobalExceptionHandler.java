package com.example.api_gateway.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidCredentialsException.class)
  public ResponseEntity<ApiErrorResponse> handleInvalidCredentials(
    InvalidCredentialsException ex
  ) {
    ApiErrorResponse error = new ApiErrorResponse(
      LocalDateTime.now(),
      HttpStatus.UNAUTHORIZED.value(),
      "Unauthorized",
      ex.getMessage()
    );

    return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(AuthenticationServiceException.class)
  public ResponseEntity<ApiErrorResponse> handleAuthServiceError(
    AuthenticationServiceException ex
  ) {
    ApiErrorResponse error = new ApiErrorResponse(
      LocalDateTime.now(),
      HttpStatus.BAD_GATEWAY.value(),
      "Bad Gateway",
      ex.getMessage()
    );

    return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiErrorResponse> handleGeneric(
    Exception ex
  ) {
    ApiErrorResponse error = new ApiErrorResponse(
      LocalDateTime.now(),
      HttpStatus.INTERNAL_SERVER_ERROR.value(),
      "Internal Server Error",
      //"Error inesperado"
      ex.getMessage()
    );

    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
