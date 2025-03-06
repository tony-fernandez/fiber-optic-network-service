package com.pyur.fiber.optic.network.exception;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.pyur.fiber.optic.network.model.Problem;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class FiberOpticExceptionHandler {

  @ExceptionHandler(ExistingHomeIdException.class)
  public ResponseEntity<Problem> handleExistingHomeIdException(
      ExistingHomeIdException e, WebRequest request) {
    return getProblemForConflict(e);
  }

  @ExceptionHandler(InvalidHomeIdFormatException.class)
  public ResponseEntity<Problem> handleInvalidHomeIdFormatException(
      InvalidHomeIdFormatException e, WebRequest request) {
    return getProblemForConflict(e);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Problem> handleGlobalException(Exception e, WebRequest request) {
    Problem problem = new Problem();
    problem.setTitle(INTERNAL_SERVER_ERROR.getReasonPhrase());
    problem.setDetail(request.getDescription(false));
    problem.setType(e.getClass().getSimpleName());
    problem.setStatus(INTERNAL_SERVER_ERROR.value());
    return new ResponseEntity<>(problem, INTERNAL_SERVER_ERROR);
  }

  @NotNull
  private ResponseEntity<Problem> getProblemForConflict(RuntimeException e) {
    Problem problem = new Problem();
    problem.setTitle(CONFLICT.getReasonPhrase());
    problem.setDetail(e.getMessage());
    problem.setType(e.getClass().getSimpleName());
    problem.setStatus(CONFLICT.value());
    return ResponseEntity.status(CONFLICT.value()).contentType(APPLICATION_JSON).body(problem);
  }
}
