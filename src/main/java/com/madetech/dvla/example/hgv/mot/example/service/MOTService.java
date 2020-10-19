package com.madetech.dvla.example.hgv.mot.example.service;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import org.springframework.stereotype.Service;

public interface MOTService {
    MOTDomain getByVehicleRegistration(String vehicleRegistration);
}
