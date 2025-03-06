package com.pyur.fiber.optic.network.persistence.repository;

import com.pyur.fiber.optic.network.persistence.model.FiberTerminationUnitEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FiberTerminationUnitRepository
    extends JpaRepository<FiberTerminationUnitEntity, Long> {

  Optional<FiberTerminationUnitEntity> findByHomeId(@Param("homeId") String homeId);
}
