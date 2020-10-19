package com.madetech.dvla.example.hgv.mot.example.mapper;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import com.madetech.dvla.example.hgv.mot.example.responses.MOTResponse;
import org.mapstruct.Mapper;

@Mapper
public interface MOTDomainToResponseMapper {
    MOTResponse MOTDomainToMOTResponse(MOTDomain domain);
}
