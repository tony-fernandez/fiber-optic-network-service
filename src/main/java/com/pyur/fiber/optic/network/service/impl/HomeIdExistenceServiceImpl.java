package com.pyur.fiber.optic.network.service.impl;

import com.pyur.fiber.optic.network.exception.ExistingHomeIdException;
import com.pyur.fiber.optic.network.persistence.repository.FiberPlateRepository;
import com.pyur.fiber.optic.network.persistence.repository.FiberTerminationUnitRepository;
import com.pyur.fiber.optic.network.service.HomeIdExistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeIdExistenceServiceImpl implements HomeIdExistenceService {

  private final FiberPlateRepository fiberPlateRepository;
  private final FiberTerminationUnitRepository fiberTerminationUnitRepository;

  @Override
  public void validateExistence(String homeId) {
    if (fiberPlateRepository.findByHomeId(homeId).isPresent()) {
      throw new ExistingHomeIdException();
    }

    if (fiberTerminationUnitRepository.findByHomeId(homeId).isPresent()) {
      throw new ExistingHomeIdException();
    }
  }
}
