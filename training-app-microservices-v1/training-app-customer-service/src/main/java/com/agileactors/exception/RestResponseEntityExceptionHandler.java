package com.agileactors.exception;

import java.time.Instant;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {ApplicationException.class})
  protected ResponseEntity<?> handleApplicationException(ApplicationException exception,
                                                         WebRequest request) {

    var responseBody = createResponseBody(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    return handleExceptionInternal(exception, responseBody, new HttpHeaders(),
        HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  @ExceptionHandler(value = {ResourceNotFoundException.class})
  protected ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                              WebRequest request) {

    var responseBody = createResponseBody(exception.getMessage(), HttpStatus.NOT_FOUND);

    return handleExceptionInternal(exception, responseBody, new HttpHeaders(),
        HttpStatus.NOT_FOUND, request);
  }

  private Map<String, Object> createResponseBody(String message, HttpStatus httpStatus) {
    return Map.of(
        "message", message,
        "timestamp", Instant.now(),
        "status", httpStatus.value()
    );
  }
}
