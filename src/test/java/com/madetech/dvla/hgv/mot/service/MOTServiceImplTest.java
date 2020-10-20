package com.madetech.dvla.hgv.mot.service;

import com.madetech.dvla.hgv.mot.domain.MOTDomain;
import com.madetech.dvla.hgv.mot.entity.MOTEntity;
import com.madetech.dvla.hgv.mot.repository.MOTRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.github.javafaker.Faker;

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

    // @Test
    // public void addMOTPersistsMOTToDatabase() {
    //     Faker faker = new Faker();
    //     String registration = faker.lorem().word();
    //     String vehicleType = faker.lorem().word();
    //     MOTDomain motDomain = MOTDomain.builder()
    //         .vehicleRegistration(registration)
    //         .vehicleType(vehicleType)
    //         .build();
    //
    //     motService.addMOT(motDomain);
    //
    //     // List<String> mockedList = mock(MyList.class);
    //     // mockedList.add("test");
    //     // verify(mockedList).add("test");
    //     //
    //     // verify(motRepository.addMOT(
    // }

    private MOTEntity createMotEntity(String testVehicleReg) {
        MOTEntity motEntity = MOTEntity.builder().vehicleRegistration(testVehicleReg).build();
        return motEntity;
    }
}
