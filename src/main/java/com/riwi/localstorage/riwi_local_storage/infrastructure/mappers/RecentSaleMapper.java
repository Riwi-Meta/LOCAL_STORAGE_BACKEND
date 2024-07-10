package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.RecentSaleResponse;

@Mapper(componentModel = "spring")
public interface RecentSaleMapper {
    //RecentSaleResponse toRecentSaleResponse((RecentSaleResponse) data);
}