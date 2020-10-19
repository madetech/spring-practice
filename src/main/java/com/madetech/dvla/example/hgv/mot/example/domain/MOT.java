package com.madetech.dvla.example.hgv.mot.example.domain;

import lombok.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class MOT {
    private String id;

    private final String vehicleType;

    private final String vehicleRegistration;
}
