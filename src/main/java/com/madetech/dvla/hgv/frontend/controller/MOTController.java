package com.madetech.dvla.hgv.frontend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MOTController {
    @GetMapping("/frontend/")
    public String helloWorld() {
        return "Hello World";
    }
}
