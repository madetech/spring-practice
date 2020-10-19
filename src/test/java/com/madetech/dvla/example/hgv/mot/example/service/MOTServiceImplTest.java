package com.madetech.dvla.example.hgv.mot.example.service;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import com.madetech.dvla.example.hgv.mot.example.entity.MOTEntity;
import com.madetech.dvla.example.hgv.mot.example.repository.MOTRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MOTServiceImplTest {
    @InjectMocks
    MOTServiceImpl motService;

    @Mock
    MOTRepository motRepository;

    @Test
    public void getMOTByVehicleRegistrationReturnsMOT() {
        String testVehicleReg = "hello";

        MOTEntity motEntity = createMotEntity(testVehicleReg);

        when(motRepository.getByVehicleRegistration(testVehicleReg)).thenReturn(motEntity);

        MOTDomain mot = motService.getByVehicleRegistration(testVehicleReg);

        assertSame(mot.getClass(), MOTDomain.class);
        assertEquals(testVehicleReg,  mot.getVehicleRegistration());
    }

    private MOTEntity createMotEntity(String testVehicleReg) {
        MOTEntity motEntity = MOTEntity.builder().vehicleRegistration(testVehicleReg).build();
        return motEntity;
    }
}
