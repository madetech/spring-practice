package com.madetech.dvla.example.hgv.mot.example.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MOTRequest {
  private String vehicleRegistration;
  private String vehicleType;
}
