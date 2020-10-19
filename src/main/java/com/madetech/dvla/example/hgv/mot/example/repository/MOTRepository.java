package com.madetech.dvla.example.hgv.mot.example.repository;

import com.madetech.dvla.example.hgv.mot.example.entity.MOTEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MOTRepository extends MongoRepository<MOTEntity, String> {
    public MOTEntity getByVehicleRegistration(String vehicleRegistration);
}
