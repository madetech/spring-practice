package com.madetech.dvla.hgv.mot.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class MOTEntity {
    private String id;

    private String vehicleType;

    private String vehicleRegistration;
}
