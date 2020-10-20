package com.madetech.dvla.example.hgv.mot.example.controller;

import com.madetech.dvla.example.hgv.mot.example.entity.MOTEntity;
import com.madetech.dvla.example.hgv.mot.example.repository.MOTRepository;
import com.madetech.dvla.example.hgv.mot.example.requests.MOTRequest;
import com.madetech.dvla.example.hgv.mot.example.responses.MOTResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MOTControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MOTRepository motRepository;

    @Test
    public void canGetAnMOT() {
        MOTEntity entity = MOTEntity.builder().vehicleRegistration("1").build();

        motRepository.save(entity);

        ResponseEntity<MOTResponse> response = testRestTemplate.exchange("/mot/1", HttpMethod.GET, null, MOTResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("1", response.getBody().getVehicleRegistration());
    }

    @Test
    public void returnNotFoundIFCantFindAnMOT() {
        ResponseEntity<MOTResponse> response = testRestTemplate.exchange("/mot/1", HttpMethod.GET, null, MOTResponse.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void canAddAnMOT() {
        HttpEntity<MOTRequest> motRequest = new HttpEntity<>(MOTRequest.builder().vehicleRegistration("adsgfad").vehicleType("zdgad").build());
        ResponseEntity<String> response = testRestTemplate.exchange("/mot", HttpMethod.POST, motRequest, String.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
