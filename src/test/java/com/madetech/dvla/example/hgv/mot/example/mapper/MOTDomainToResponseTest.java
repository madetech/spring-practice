package com.madetech.dvla.example.hgv.mot.example.mapper;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import com.madetech.dvla.example.hgv.mot.example.responses.MOTResponse;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MOTDomainToResponseTest {

    MOTDomainToResponseMapper mapper = Mappers.getMapper(MOTDomainToResponseMapper.class);

    @Test
    public void mapReturnsValidResponseObject() {
        MOTDomain mot = MOTDomain.builder()
                .id("123")
                .vehicleRegistration("ABC 123D")
                .vehicleType("HippyBus")
                .build();

        MOTResponse response = mapper.MOTDomainToMOTResponse(mot);

        assertEquals(mot.getVehicleRegistration(), response.getVehicleRegistration());
        assertEquals(mot.getVehicleType(), response.getVehicleType());
    }
}
