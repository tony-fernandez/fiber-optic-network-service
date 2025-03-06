package com.pyur.fiber.optic.network.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseClarifyEntity {
  @Id
  @Column(
      name = "objid"
  )
  private Long id;

  public BaseClarifyEntity() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

