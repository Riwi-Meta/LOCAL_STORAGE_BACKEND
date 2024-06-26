package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Membership;

@Mapper(componentModel = "spring")

public interface MembershipMapper {
  
    public MembershipResponse toResponse (Membership membership);

}
