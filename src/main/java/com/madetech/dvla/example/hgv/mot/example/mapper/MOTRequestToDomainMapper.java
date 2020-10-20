package com.madetech.dvla.example.hgv.mot.example.mapper;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import com.madetech.dvla.example.hgv.mot.example.requests.MOTRequest;
import org.mapstruct.Mapper;

@Mapper
public interface MOTRequestToDomainMapper {
    MOTDomain MOTRequestToMOTDomain(MOTRequest motRequest);
}
