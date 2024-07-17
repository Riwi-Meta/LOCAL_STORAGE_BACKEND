package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventoryResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Inventory;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryDisableMapper {
    
    @Mappings({
        @Mapping(target = "id",ignore = true),
        @Mapping(target = "saleDetails",ignore = true),
        @Mapping(target = "supplierOrders",ignore = true),
        @Mapping(target = "product",ignore = true),
        @Mapping(target = "branch",ignore = true),
        @Mapping(target = "quantity",ignore = true),
        @Mapping(target = "lastUpdateDate",ignore = true),
        @Mapping(target = "expirationDate",ignore = true),

    })
    Inventory toEntity(InventoryRequest request);

    @InheritConfiguration
    InventoryResponse toResponse(Inventory entity);

    List<Inventory> toEntityList(List<InventoryRequest> request);

    List<InventoryResponse> toResponseList(List<Inventory> entity);
}
