package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.RoleResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Role;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

    RoleResponse toResponse(Role entity);

    List<RoleResponse> toResponseList(List<Role> entity);
    

}
