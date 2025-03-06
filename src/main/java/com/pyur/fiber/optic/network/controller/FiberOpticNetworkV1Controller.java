package com.pyur.fiber.optic.network.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.pyur.fiber.optic.network.api.V1Api;
import com.pyur.fiber.optic.network.model.Bracket;
import com.pyur.fiber.optic.network.model.FiberData;
import com.pyur.fiber.optic.network.model.FiberTerminationPoint;
import com.pyur.fiber.optic.network.model.FiberTwistModule;
import com.pyur.fiber.optic.network.model.UpdateBracketRequest;
import com.pyur.fiber.optic.network.service.HomeIdValidationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FiberOpticNetworkV1Controller implements V1Api {

  private final HomeIdValidationService homeIdValidationService;

  @Override
  public ResponseEntity<FiberTerminationPoint> createFiberTerminationPoint(
      Long weId, String X_MAB_ID, FiberTerminationPoint fiberTerminationPoint) {
    return V1Api.super.createFiberTerminationPoint(weId, X_MAB_ID, fiberTerminationPoint);
  }

  @Override
  public ResponseEntity<List<FiberTerminationPoint>> getFiberTerminationPoints(
      Long residentialUnitId) {
    return V1Api.super.getFiberTerminationPoints(residentialUnitId);
  }

  @Override
  public ResponseEntity<FiberTerminationPoint> getFiberTerminationPoint(
      String terminationEndpointId) {
    return V1Api.super.getFiberTerminationPoint(terminationEndpointId);
  }

  @Override
  public ResponseEntity<FiberTwistModule> replaceFiberTwistModule(
      String fiberTerminationPointId, String X_MAB_ID, FiberTwistModule fiberTwistModule) {
    return V1Api.super.replaceFiberTwistModule(fiberTerminationPointId, X_MAB_ID, fiberTwistModule);
  }

  @Override
  public ResponseEntity<FiberData> updateFiberData(
      String fiberTerminationPointId, Integer fiberId, String X_MAB_ID, FiberData fiberData) {
    return V1Api.super.updateFiberData(fiberTerminationPointId, fiberId, X_MAB_ID, fiberData);
  }

  @Override
  public ResponseEntity<Void> updateBracket(
      String fiberTerminationPointId,
      String bracketId,
      String X_MAB_ID,
      UpdateBracketRequest updateBracketRequest) {
    return V1Api.super.updateBracket(
        fiberTerminationPointId, bracketId, X_MAB_ID, updateBracketRequest);
  }

  @Override
  public ResponseEntity<List<Bracket>> getAllBrackets(String terminationEndpointId) {
    return V1Api.super.getAllBrackets(terminationEndpointId);
  }

  @Override
  public ResponseEntity<Bracket> getBracket(String terminationEndpointId, String bracketHomeId) {
    return V1Api.super.getBracket(terminationEndpointId, bracketHomeId);
  }

  @Override
  public ResponseEntity<String> validate(String fiberTerminationPointId) {
    homeIdValidationService.validateHomeId(fiberTerminationPointId);
    return ok("Ok");
  }
}
