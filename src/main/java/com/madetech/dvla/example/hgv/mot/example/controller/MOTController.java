package com.madetech.dvla.example.hgv.mot.example.controller;

import com.madetech.dvla.example.hgv.mot.example.responses.MOTResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MOTController {

    @GetMapping("/mot/{vehicleRegistration}")
    public ResponseEntity<MOTResponse> GetByRegistration(@PathVariable String vehicleRegistration){
        return null;
    }
}
