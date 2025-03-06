package com.pyur.fiber.optic.network.service;

public interface HomeIdValidator {

  /**
   * Validates the given homeId.
   *
   * @param homeId the homeId to validate.
   */
  void validate(String homeId);
}
