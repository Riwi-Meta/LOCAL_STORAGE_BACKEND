package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.RoleRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RoleResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Role;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleCreateMapper {
    @Mapping(target = "id", ignore = true)
    Role toEntity(RoleRequest request);

    @InheritInverseConfiguration
    RoleResponse toResponse(Role entity);
    
} 
