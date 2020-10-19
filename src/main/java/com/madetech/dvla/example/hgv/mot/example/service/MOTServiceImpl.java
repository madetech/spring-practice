package com.madetech.dvla.example.hgv.mot.example.service;

import com.madetech.dvla.example.hgv.mot.example.domain.MOTDomain;
import com.madetech.dvla.example.hgv.mot.example.entity.MOTEntity;
import com.madetech.dvla.example.hgv.mot.example.mapper.MOTEntityToDomainMapper;
import com.madetech.dvla.example.hgv.mot.example.repository.MOTRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MOTServiceImpl implements MOTService {
    @Autowired
    private MOTRepository motRepository;

    private MOTEntityToDomainMapper mapper = Mappers.getMapper(MOTEntityToDomainMapper.class);

    @Override
    public MOTDomain getByVehicleRegistration(String vehicleRegistration) {
        MOTEntity entity = motRepository.getByVehicleRegistration(vehicleRegistration);

        if(entity == null) return null;

        return mapper.MOTEntityToMOTDomain(entity);
    }
}
