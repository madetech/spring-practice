package com.madetech.dvla.hgv.mot.mapper;

import com.madetech.dvla.hgv.mot.domain.MOTDomain;
import com.madetech.dvla.hgv.mot.entity.MOTEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.*;

public class MOTEntityToDomainTest {

    MOTEntityToDomainMapper mapper = Mappers.getMapper(MOTEntityToDomainMapper.class);

    @Test
    public void mapReturnsValidBusinessObject() {
        MOTEntity mot = MOTEntity.builder().id("123").vehicleRegistration("ABC 123D").vehicleType("HippyBus").build();

        MOTDomain result = mapper.MOTEntityToMOTDomain(mot);

        assertEquals(mot.getVehicleRegistration(), result.getVehicleRegistration());
        assertEquals(mot.getVehicleType(), result.getVehicleType());
    }
}
