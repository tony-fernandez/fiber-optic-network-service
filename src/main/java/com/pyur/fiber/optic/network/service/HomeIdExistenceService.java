package com.pyur.fiber.optic.network.service;

public interface HomeIdExistenceService {

  /**
   * Check if homeId exists
   *
   * @param homeId the homeId.
   */
  void validateExistence(String homeId);
}
