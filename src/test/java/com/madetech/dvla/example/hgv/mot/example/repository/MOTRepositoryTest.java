package com.madetech.dvla.example.hgv.mot.example.repository;

import com.madetech.dvla.example.hgv.mot.example.entity.MOTEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class MOTRepositoryTest {

  @Autowired
  MOTRepository repository;

  @Test
  public void canGetAMOTByRegistration() {
    MOTEntity mot = MOTEntity.builder().vehicleRegistration("XY123").build();
    repository.save(mot);

    MOTEntity result = repository.getByVehicleRegistration("XY123");

    assertNotNull(result.getId());
    assertEquals("XY123", result.getVehicleRegistration());
  }

  @Test
  public void returnNullWhenRegistrationDoesNotExists() {
    assertNull(repository.getByVehicleRegistration("XY123"));
  }
}
