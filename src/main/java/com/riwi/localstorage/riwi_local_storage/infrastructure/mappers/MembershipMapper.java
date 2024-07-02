package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.*;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.MembershipRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Membership;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MembershipMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "enabled", ignore = true)
    })
    Membership requestToEntity(MembershipRequest membershipRequest);

    MembershipResponse entityToResponse(Membership membership);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "enabled", ignore = true)
    })
    Membership updateEntity(MembershipRequest membershipRequest, @MappingTarget Membership membership);

}
