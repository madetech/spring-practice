package com.madetech.dvla.hgv.mot.mapper;

import com.madetech.dvla.hgv.mot.domain.MOTDomain;
import com.madetech.dvla.hgv.mot.entity.MOTEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MOTEntityToDomainMapper {
	public MOTDomain MOTEntityToMOTDomain(MOTEntity entity);
}
