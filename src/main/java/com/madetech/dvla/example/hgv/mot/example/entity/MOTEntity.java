package com.madetech.dvla.example.hgv.mot.example.entity;

import lombok.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class MOTEntity {
    private String id;

    private final String vehicleType;

    private final String vehicleRegistration;
}
