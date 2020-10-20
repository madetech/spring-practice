package com.madetech.dvla.hgv.mot.entity;

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
