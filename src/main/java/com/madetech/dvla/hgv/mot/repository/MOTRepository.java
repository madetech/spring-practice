package com.madetech.dvla.hgv.mot.repository;

import com.madetech.dvla.hgv.mot.entity.MOTEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MOTRepository extends MongoRepository<MOTEntity, String> {
    public MOTEntity getByVehicleRegistration(String vehicleRegistration);
}
