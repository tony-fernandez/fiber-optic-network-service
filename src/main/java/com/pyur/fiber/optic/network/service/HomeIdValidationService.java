package com.pyur.fiber.optic.network.service;

public interface HomeIdValidationService {

  /**
   * Validates homeId according to the following rules:
   *
   * @param homeId the homeId.
   */
  void validateHomeId(String homeId);
}
