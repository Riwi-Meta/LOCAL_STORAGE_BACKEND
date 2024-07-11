package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.DiscountRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.DiscountRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.DiscountResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Discount;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiscountMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "sales", ignore = true)
  @Mapping(target = "isActive", ignore = true)
  Discount discountRequestToDiscount(DiscountRequest discountRequest);

  DiscountResponse discountToDiscountResponse(Discount discount);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "sales", ignore = true)
  Discount updateDiscount(DiscountRequestUpdate discountRequestUpdate);
}