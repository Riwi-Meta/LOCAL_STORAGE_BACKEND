package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.DiscountRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.DiscountRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.DiscountResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Discount;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

public interface IDiscountService extends CreateService<DiscountRequest, DiscountResponse>,
        ReadAllService<DiscountResponse>, ReadService<DiscountResponse, String>,
        UpdateService<DiscountRequestUpdate, DiscountResponse, String> {

    Page<DiscountResponse> findAllByIsActive(boolean isActive, Pageable pageable);

    public Discount findDiscount(String id);

    public void updateDiscountStatus(String id, boolean isActive);
}

