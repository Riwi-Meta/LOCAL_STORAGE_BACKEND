package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.DiscountRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.DiscountRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.DiscountResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Discount;

@Mapper
public interface DiscountMapper {

  Discount discountRequestToDiscount(DiscountRequest discountRequest);

  DiscountResponse discountToDiscountResponse(Discount discount);

  Discount discountRequestUpdateToDiscount(DiscountRequestUpdate discountRequestUpdate);
}