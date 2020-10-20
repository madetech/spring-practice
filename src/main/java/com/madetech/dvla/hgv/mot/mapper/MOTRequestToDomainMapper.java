package com.madetech.dvla.hgv.mot.mapper;

import com.madetech.dvla.hgv.mot.domain.MOTDomain;
import com.madetech.dvla.hgv.mot.requests.MOTRequest;
import org.mapstruct.Mapper;

@Mapper
public interface MOTRequestToDomainMapper {
    MOTDomain MOTRequestToMOTDomain(MOTRequest motRequest);
}
