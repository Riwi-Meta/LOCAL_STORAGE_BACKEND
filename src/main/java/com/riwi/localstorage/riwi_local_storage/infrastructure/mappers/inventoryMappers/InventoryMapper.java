package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventaryResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Inventory;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryMapper {

    InventaryResponse toResponse(Inventory entity);

    List<InventaryResponse> toResponseList(List<Inventory> entity);
}
