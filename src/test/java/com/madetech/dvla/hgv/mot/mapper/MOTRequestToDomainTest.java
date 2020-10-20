package com.madetech.dvla.example.hgv.mot.example.mapper;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import com.madetech.dvla.example.hgv.mot.example.requests.MOTRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MOTRequestToDomainTest {

    MOTRequestToDomainMapper mapper = Mappers.getMapper(MOTRequestToDomainMapper.class);

    @Test
    public void mapReturnsValidResponseObject() {
        MOTRequest mot = MOTRequest.builder()
                .vehicleRegistration("ABC 123D")
                .vehicleType("HippyBus")
                .build();

        MOTDomain response = mapper.MOTRequestToMOTDomain(mot);

        assertEquals(mot.getVehicleRegistration(), response.getVehicleRegistration());
        assertEquals(mot.getVehicleType(), response.getVehicleType());
    }
}
