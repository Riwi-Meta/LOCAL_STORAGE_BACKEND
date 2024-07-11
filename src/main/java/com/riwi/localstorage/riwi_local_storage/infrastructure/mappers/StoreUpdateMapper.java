package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.StoreRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.StoreResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Store;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StoreUpdateMapper {
    
    @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "branches", ignore = true),
    @Mapping(target = "user", ignore = true)
    })
    Store toEntity(StoreRequestUpdate request);

    @InheritInverseConfiguration
    StoreResponse toResponse(Store entity);

    List<Store> toEntityList(List<StoreRequestUpdate> request);

    List<StoreResponse> toResponseList(List<Store> entity);
}
