package com.example.api_gateway.exception;

import java.time.LocalDateTime;

public class ApiErrorResponse {
  private final LocalDateTime timestamp;
  private final int status;
  private final String error;
  private final String message;

  public ApiErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    String message
  ) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.message = message;
  }

  public LocalDateTime getLocalDateTime() {
    return this.timestamp;
  }

  public int getStatus() {
    return this.status;
  }

  public String getError() {
    return this.error;
  }

  public String getMessage() {
    return this.message;
  }
}
