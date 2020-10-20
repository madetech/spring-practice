package com.madetech.dvla.example.hgv.mot.example.requests;

import lombok.Data;

@Data
public class MOTRequest {
  private String vehicleRegistration;
  private String vehicleType;
}
