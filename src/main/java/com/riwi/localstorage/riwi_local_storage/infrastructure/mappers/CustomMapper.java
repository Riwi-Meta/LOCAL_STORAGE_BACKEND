package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CustomRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CustomResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Custom;

@Mapper(componentModel = "spring")
public interface CustomMapper {

    @Mappings({
        @Mapping(target = "store.id", source = "storeId"),
        @Mapping(target = "minimumStock", source = "minimumStock")
    })    
    Custom toEntity(CustomRequest customRequest);

    CustomResponse toResponse(Custom entity);

    void updateCustom(CustomRequest customRequest, @MappingTarget Custom CustomEntity);
}
