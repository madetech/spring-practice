package com.madetech.dvla.example.hgv.mot.example.repository;

import com.madetech.dvla.example.hgv.mot.example.domain.MOT;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MOTRepository extends MongoRepository<MOT, String> {
    public MOT getByVehicleRegistration(String vehicleRegistration);
}
