package com.madetech.dvla.example.hgv.mot.example.mapper;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import com.madetech.dvla.example.hgv.mot.example.entity.MOTEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface MOTEntityToDomainMapper {
	MOTDomain MOTEntityToMOTDomain(MOTEntity entity);

	MOTEntity MOTDomainToMOTEntity(MOTDomain mot);
}
