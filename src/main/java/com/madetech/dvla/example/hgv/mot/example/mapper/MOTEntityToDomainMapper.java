package com.madetech.dvla.example.hgv.mot.example.mapper;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import com.madetech.dvla.example.hgv.mot.example.entity.MOTEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MOTEntityToDomainMapper {
	public MOTDomain MOTEntityToMOTDomain(MOTEntity entity);
}
