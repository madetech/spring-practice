package com.madetech.dvla.example.hgv.mot.example.service;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;

public interface MOTService {
    MOTDomain getByVehicleRegistration(String vehicleRegistration);
}
