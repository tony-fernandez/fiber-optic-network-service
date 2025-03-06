package com.pyur.fiber.optic.network.exception;

public class ExistingHomeIdException extends RuntimeException {

  private static final String MESSAGE =
      "Diese Home-ID ist bereits im System hinterlegt und wurde nicht gespeichert. Bitte nutze eine andere Home-ID.";

  public ExistingHomeIdException() {
    super(MESSAGE);
  }
}
