package dev.lzzgabriel.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.lzzgabriel.course.services.exceptions.DatabaseException;
import dev.lzzgabriel.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    var error = "Resource not found";
    var status = HttpStatus.NOT_FOUND;
    var err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
    var error = "Database error";
    var status = HttpStatus.BAD_REQUEST;
    var err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

}
