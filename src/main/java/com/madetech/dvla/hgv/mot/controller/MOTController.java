package com.madetech.dvla.hgv.mot.controller;

import com.madetech.dvla.hgv.mot.domain.MOTDomain;
import com.madetech.dvla.hgv.mot.mapper.MOTDomainToResponseMapper;
import com.madetech.dvla.hgv.mot.responses.MOTResponse;
import com.madetech.dvla.hgv.mot.service.MOTService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MOTController {
    @Autowired
    private MOTService motService;

    private MOTDomainToResponseMapper mapper = Mappers.getMapper(MOTDomainToResponseMapper.class);

    // No unit tests because it's covered by com.madetech.dvla.hgv.mot.controller.MOTControllerIntegrationTest
    @GetMapping("/mot/{vehicleRegistration}")
    public ResponseEntity<MOTResponse> GetByRegistration(@PathVariable String vehicleRegistration){
        MOTDomain domain = motService.getByVehicleRegistration(vehicleRegistration);
        if(domain == null || domain.getId() == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(mapper.MOTDomainToMOTResponse(domain), HttpStatus.OK);
    }
}
