package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.StoreRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.StoreUpdateDisableRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.StoreResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Store;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StoreDisableMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", ignore = true),
            @Mapping(target = "branches", ignore = true),
            @Mapping(target = "user", ignore = true)
    })
    Store toEntity(StoreUpdateDisableRequest request);

    @InheritInverseConfiguration
    StoreResponse toResponse(StoreUpdateDisableRequest request);

    List<Store> toEntityList(List<StoreUpdateDisableRequest> request);

    List<StoreResponse> toResponseList(List<Store> entity);
}
