package com.madetech.dvla.example.hgv.mot.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MOTDomain {
    private String id;
    private String vehicleRegistration;
    private String vehicleType;
}
