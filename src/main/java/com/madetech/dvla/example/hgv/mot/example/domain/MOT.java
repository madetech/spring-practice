package com.madetech.dvla.example.hgv.mot.example.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(exclude = { "id" })
public class MOT {
    private String id;

    private String vehicleType;

    private String vehicleRegistration;
}
