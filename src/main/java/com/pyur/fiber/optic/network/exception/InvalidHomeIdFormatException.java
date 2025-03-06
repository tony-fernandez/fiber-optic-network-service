package com.pyur.fiber.optic.network.exception;

public class InvalidHomeIdFormatException extends RuntimeException {

  private static final String MESSAGE = "Die Home-ID ist nicht valide. Bitte Eingabe überprüfen.";

  public InvalidHomeIdFormatException() {
    super(MESSAGE);
  }
}
