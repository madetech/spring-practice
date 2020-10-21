package com.madetech.dvla.hgv.mot.mapper;

import com.madetech.dvla.hgv.mot.domain.MOTDomain;
import com.madetech.dvla.hgv.mot.responses.MOTResponse;
import org.mapstruct.Mapper;

@Mapper
public interface MOTDomainToResponseMapper {
    MOTResponse MOTDomainToMOTResponse(MOTDomain domain);
}
