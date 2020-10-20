package com.madetech.dvla.hgv.mot.repository;

import com.github.javafaker.Faker;
import com.madetech.dvla.hgv.mot.entity.MOTEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class MOTRepositoryTest {

  @Autowired
  MOTRepository repository;

  private final Faker faker = new Faker();

  @Test
  public void canGetAnMOTByRegistration() {
    MOTEntity mot = MOTEntity.builder().vehicleRegistration(faker.lorem().word()).build();
    repository.save(mot);

    MOTEntity result = repository.getByVehicleRegistration(mot.getVehicleRegistration());

    assertNotNull(result.getId());
    assertEquals(mot.getVehicleRegistration(), result.getVehicleRegistration());
  }

  @Test
  public void returnNullWhenRegistrationDoesNotExists() {
    assertNull(repository.getByVehicleRegistration("does-not-exist"));
  }
}
