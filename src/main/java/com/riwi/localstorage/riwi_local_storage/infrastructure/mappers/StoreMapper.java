package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.StoreRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.StoreResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Store;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StoreMapper {
    
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "branches", ignore = true),
        @Mapping(target = "user.id", source = "user_id")
    })
    Store toEntity(StoreRequest request);

    @InheritInverseConfiguration
    StoreResponse toResponse(Store entity);

    List<Store> toEntityList(List<StoreRequest> request);

    List<StoreResponse> toResponseList(List<Store> entity);
}