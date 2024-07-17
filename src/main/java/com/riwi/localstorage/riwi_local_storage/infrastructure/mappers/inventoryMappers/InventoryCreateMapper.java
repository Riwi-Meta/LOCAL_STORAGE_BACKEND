package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventaryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventaryResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Inventory;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryCreateMapper {

    Inventory toEntity(InventaryRequest request);

    @InheritConfiguration
    InventaryResponse toResponse(Inventory entity);

    List<Inventory> toEntityList(List<InventaryRequest> request);

    List<InventaryResponse> toResponseList(List<Inventory> entity);
}
