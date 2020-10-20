package com.madetech.dvla.hgv.mot.mapper;

import com.madetech.dvla.hgv.mot.domain.MOTDomain;
import com.madetech.dvla.hgv.mot.entity.MOTEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface MOTEntityDomainMapper {
	MOTDomain MOTEntityToMOTDomain(MOTEntity entity);

	MOTEntity MOTDomainToMOTEntity(MOTDomain mot);
}
