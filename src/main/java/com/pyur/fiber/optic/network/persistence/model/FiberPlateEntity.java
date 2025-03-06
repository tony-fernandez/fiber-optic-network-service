package com.pyur.fiber.optic.network.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "table_x_fiber_plate2")
public class FiberPlateEntity extends BaseClarifyEntity {

  @Column(name = "x_home_id2")
  private String homeId;
}
