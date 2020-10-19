package com.madetech.dvla.example.hgv.mot.example.service;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import com.madetech.dvla.example.hgv.mot.example.entity.MOTEntity;
import com.madetech.dvla.example.hgv.mot.example.repository.MOTRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MOTServiceImplTest {
    @InjectMocks
    MOTServiceImpl motService;

    @Mock
    MOTRepository motRepository;

    @Test
    public void getMOTByVehicleRegistrationReturnsMOT() {
        MOTEntity motEntity = MOTEntity.builder().build();

        when(motRepository.getByVehicleRegistration("foo")).thenReturn(motEntity);

        MOTDomain mot = motService.getByVehicleRegistration("foo");

        assertNotNull(mot);
    }
}
