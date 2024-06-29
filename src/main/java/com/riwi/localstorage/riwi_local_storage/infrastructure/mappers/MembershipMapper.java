package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.MembershipRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Membership;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MembershipMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "user", ignore = true)
  @Mapping(target = "enabled", ignore = true)
  Membership requestToEntity(MembershipRequest membershipRequest);

  MembershipResponse entityToResponse(Membership membership);

}
