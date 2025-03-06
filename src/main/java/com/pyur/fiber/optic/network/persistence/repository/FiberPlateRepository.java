package com.pyur.fiber.optic.network.persistence.repository;

import com.pyur.fiber.optic.network.persistence.model.FiberPlateEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FiberPlateRepository extends JpaRepository<FiberPlateEntity, Long> {

  Optional<FiberPlateEntity> findByHomeId(@Param("homeId") String homeId);
}
