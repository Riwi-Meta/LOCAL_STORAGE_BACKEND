package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers;

import java.util.List;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventoryRequest;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Inventory;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryCreateMapper {
    @Mappings({
            @Mapping(target = "branch.id", source = "branchId"),
            @Mapping(target = "product.id", source = "productId")
    })

    Inventory toEntity(InventoryRequest request);

    InventoryResponse toResponse(Inventory entity);

    List<Inventory> toEntityList(List<InventoryRequest> request);

    List<InventoryResponse> toResponseList(List<Inventory> entity);
}
