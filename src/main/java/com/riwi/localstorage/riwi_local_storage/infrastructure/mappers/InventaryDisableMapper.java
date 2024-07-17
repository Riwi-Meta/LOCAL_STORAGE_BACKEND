package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventaryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventaryResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Inventory;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventaryDisableMapper {
    
    @Mappings({
        @Mapping(target = "saleDetails",ignore = true),
        @Mapping(target = "supplierOrders",ignore = true),
        @Mapping(target = "product",ignore = true),
        @Mapping(target = "branch",ignore = true),
        @Mapping(target = "quantity",ignore = true),
        @Mapping(target = "lastUpdateDate",ignore = true),
        @Mapping(target = "expirationDate",ignore = true),

    })
    Inventory toEntity(InventaryRequest request);

    @InheritConfiguration
    InventaryResponse toResponse(Inventory entity);

    List<Inventory> toEntityList(List<InventaryRequest> request);

    List<InventaryResponse> toResponseList(List<Inventory> entity);
}
