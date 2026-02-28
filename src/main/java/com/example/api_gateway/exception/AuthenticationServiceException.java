package com.example.api_gateway.exception;

public class AuthenticationServiceException extends RuntimeException {

  public AuthenticationServiceException(String message) {
    super(message);
  }
}
