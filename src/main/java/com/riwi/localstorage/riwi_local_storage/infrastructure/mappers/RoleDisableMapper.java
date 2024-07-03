package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.RoleRequestUpdateStatus;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RoleResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Role;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleDisableMapper {
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "name", ignore = true),
        @Mapping(target = "description", ignore = true),
        @Mapping(target = "users", ignore = true)
    })
    Role toEntity(RoleRequestUpdateStatus request);

    @InheritInverseConfiguration
    RoleResponse toResponse(Role entity);

    List<Role> toEntityList(List<RoleRequestUpdateStatus> request);

    List<RoleResponse> toResponseList(List<Role> entity);
}
