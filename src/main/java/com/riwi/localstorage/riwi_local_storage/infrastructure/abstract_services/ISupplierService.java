package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.SupplierRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponse;

public interface ISupplierService {   
    
    SupplierResponse create(SupplierRequest request);

    Page<SupplierResponse> getAll(Pageable pageable);

    Optional<SupplierResponse> getById(Long id);
}
