package com.madetech.dvla.example.hgv.mot.example.mapper;

import com.madetech.dvla.example.hgv.mot.example.entity.MOTEntity;
import org.junit.jupiter.api.Test;

public class MOTEntityToDomainTest {

    private final MOTEntityToDomain mapper = new MOTEntityToDomain();

    @Test
    public void mapReturnsValidBusinessObject() {
        MOTEntity mot = MOTEntity.builder().id("123").vehicleRegistration("ABC 123D").vehicleType("HippyBus").build();

        // MOT reul
    }
}
