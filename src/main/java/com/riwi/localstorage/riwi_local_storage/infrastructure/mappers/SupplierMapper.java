package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.SupplierRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponseRelations;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper {


  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "companyId.id", source = "companyId")
  })
    Supplier toSupplier(SupplierRequest supplierRequest);


  @Mappings({
    @Mapping(target = "company", source = "companyId")
  })
    SupplierResponseRelations toSupplierResponse(Supplier supplier);


      void updateFromSupplierRequest(SupplierRequest userRequest, @MappingTarget Supplier supplier);
}
