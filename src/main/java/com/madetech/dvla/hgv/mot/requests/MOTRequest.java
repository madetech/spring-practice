package com.madetech.dvla.hgv.mot.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MOTRequest {
  private String vehicleRegistration;
  private String vehicleType;
}
