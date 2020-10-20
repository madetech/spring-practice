package com.madetech.dvla.hgv.mot.controller;

import com.madetech.dvla.hgv.mot.domain.MOTDomain;
import com.madetech.dvla.hgv.mot.mapper.MOTDomainToResponseMapper;
import com.madetech.dvla.hgv.mot.mapper.MOTRequestToDomainMapper;
import com.madetech.dvla.hgv.mot.requests.MOTRequest;
import com.madetech.dvla.hgv.mot.responses.MOTResponse;
import com.madetech.dvla.hgv.mot.service.MOTService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class MOTController {
    @Autowired
    private MOTService motService;

    private final MOTDomainToResponseMapper motDomainToResponseMapper = Mappers.getMapper(MOTDomainToResponseMapper.class);

    private final MOTRequestToDomainMapper motRequestToDomainMapper = Mappers.getMapper(MOTRequestToDomainMapper.class);

    // No unit tests because it's covered by com.madetech.dvla.hgv.mot.controller.MOTControllerIntegrationTest
    @GetMapping("/mot/{vehicleRegistration}")
    public ResponseEntity<MOTResponse> GetByRegistration(@PathVariable String vehicleRegistration){
        MOTDomain domain = motService.getByVehicleRegistration(vehicleRegistration);
        if(domain == null || domain.getId() == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(motDomainToResponseMapper.MOTDomainToMOTResponse(domain), HttpStatus.OK);
    }

    @PostMapping("/mot")
    public ResponseEntity<String> add(@RequestBody MOTRequest mot) throws URISyntaxException {
        MOTDomain motDomain = motRequestToDomainMapper.MOTRequestToMOTDomain(mot);
        motService.addMOT(motDomain);
        return ResponseEntity.created(new URI(String.format("/mot/%s", motDomain.getVehicleRegistration()))).build();
    }
}