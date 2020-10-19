package com.madetech.dvla.example.hgv.mot.example.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class MOT {
    private String id;

    private final String vehicleType;

    private final String vehicleRegistration;
}
