package com.pyur.fiber.optic.network.service.impl;

import com.pyur.fiber.optic.network.service.HomeIdExistenceService;
import com.pyur.fiber.optic.network.service.HomeIdValidationService;
import com.pyur.fiber.optic.network.service.HomeIdValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeIdValidationServiceImpl implements HomeIdValidationService {

  private final HomeIdExistenceService homeIdExistenceService;
  private final HomeIdValidator homeIdValidator;

  @Override
  public void validateHomeId(String homeId) {
    // Validate homeId format
    homeIdValidator.validate(homeId);
    // Validate homeId existence
    homeIdExistenceService.validateExistence(homeId);
  }
}
