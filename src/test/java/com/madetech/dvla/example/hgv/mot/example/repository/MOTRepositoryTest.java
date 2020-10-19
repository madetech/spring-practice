package com.madetech.dvla.example.hgv.mot.example.repository;

import com.madetech.dvla.example.hgv.mot.example.domain.MOT;
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
    MOT mot = MOT.builder().vehicleRegistration("XY123").build();
    repository.save(mot);

    MOT result = repository.getByVehicleRegistration("XY123");

    assertNotNull(result.getId());
    assertEquals("XY123", result.getVehicleRegistration());
  }

  @Test
  public void returnNullWhenRegistrationDoesNotExists() {
    assertNull(repository.getByVehicleRegistration("XY123"));
  }
}
