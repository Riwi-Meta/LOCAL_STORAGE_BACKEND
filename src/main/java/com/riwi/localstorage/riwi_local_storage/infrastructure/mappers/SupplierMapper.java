package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.SupplierRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper {


    @Mapping(target = "id", ignore = true)
    Supplier toSupplier(SupplierRequest supplierRequest);


 
    SupplierResponse toSupplierResponse(Supplier supplier);


      void updateFromSupplierRequest(SupplierRequest userRequest, @MappingTarget Supplier supplier);
}
