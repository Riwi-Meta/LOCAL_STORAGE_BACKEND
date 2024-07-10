package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CustomRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CustomResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Custom;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.CustomRespository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ICustomServise;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.CustomMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomService implements ICustomServise{

    @Autowired
    private CustomRespository customRespository;

    @Autowired
    private CustomMapper customMapper;

    @Override
    public CustomResponse create(CustomRequest request) {

        Custom custom = customMapper.toEntity(request);
        Custom saveCustum = customRespository.save(custom);

        return customMapper.toResponse(saveCustum);
    }

    @Override
    public CustomResponse update(String id, CustomRequest request) {

        Custom customUpdate = find(id);

        customMapper.updateCustom(request, customUpdate);
        Custom saveCustum = customRespository.save(customUpdate);

        return customMapper.toResponse(saveCustum);

    }

    @Override
    public Page<CustomResponse> getAll(Pageable pageable) {

        return customRespository.findAll(pageable).map(customMapper::toResponse);
    }

    private Custom find(String id) {
        return this.customRespository.findById(id).orElseThrow(null);
    }

}
