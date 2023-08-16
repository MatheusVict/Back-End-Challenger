package dev.matheusvictor.backendchallenger.infra;

import dev.matheusvictor.backendchallenger.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity threatDuplicateEntryException(DataIntegrityViolationException e) {
    ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "400");
    return ResponseEntity.badRequest().body(exceptionDTO);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity exception(Exception e) {
    ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "500");
    return ResponseEntity.internalServerError().body(exceptionDTO);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity entityNotFoundException(EntityNotFoundException e) {
    return ResponseEntity.notFound().build();
  }
}
