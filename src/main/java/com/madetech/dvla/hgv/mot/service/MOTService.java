package com.madetech.dvla.hgv.mot.service;

import com.madetech.dvla.hgv.mot.domain.MOTDomain;

public interface MOTService {
    MOTDomain getByVehicleRegistration(String vehicleRegistration);

    void addMOT(MOTDomain mot);
}
