package com.madetech.dvla.example.hgv.mot.example.controller;

import com.github.javafaker.Faker;
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

    Faker faker = new Faker();

    private String vehicleRegistration() { return faker.numerify("XY####"); }

    private String vehicleType() { return faker.princessBride().character(); }

    @Test
    public void canGetAnMOT() {
        String rego = vehicleRegistration();
        MOTEntity entity = MOTEntity.builder().vehicleRegistration(rego).build();
        motRepository.save(entity);

        ResponseEntity<MOTResponse> response = testRestTemplate.exchange(String.format("/mot/%s", rego), HttpMethod.GET, null, MOTResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rego, response.getBody().getVehicleRegistration());
    }

    @Test
    public void returnNotFoundIFCantFindAnMOT() {
        ResponseEntity<MOTResponse> response = testRestTemplate.exchange("/mot/does-not-exist", HttpMethod.GET, null, MOTResponse.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void canAddAnMOT() {
        String rego = vehicleRegistration();
        HttpEntity<MOTRequest> request = new HttpEntity<>(MOTRequest.builder().vehicleRegistration(rego).build());

        ResponseEntity<String> response = testRestTemplate.exchange("/mot", HttpMethod.POST, request, String.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(String.format("/mot/%s", rego), response.getHeaders().getLocation().toString());
    }

//    @Test
//    public void addMOTFailsIfAlreadyExists() {
//        String rego = vehicleRegistration();
//        MOTEntity entity = MOTEntity.builder().vehicleRegistration(rego).build();
//        motRepository.save(entity);
//        HttpEntity<MOTRequest> request = new HttpEntity<>(MOTRequest.builder().vehicleRegistration(rego).build());
//
//        ResponseEntity<String> response = testRestTemplate.exchange("/mot", HttpMethod.POST, request, String.class);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//    }
}
