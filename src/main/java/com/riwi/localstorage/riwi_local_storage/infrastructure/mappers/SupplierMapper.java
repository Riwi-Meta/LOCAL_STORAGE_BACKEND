package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.SupplierRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponseRelations;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface SupplierMapper {
  @Mappings(
    {
      @Mapping(target = "id", ignore = true),
      @Mapping(target = "isEnable", ignore = true),
      @Mapping(target = "company.id", source = "companyId"),
    }
  )
  Supplier toSupplier(SupplierRequest supplierRequest);

  SupplierResponseRelations toSupplierResponse(Supplier supplier);

  void updateFromSupplierRequest(
    SupplierRequest supplierRequest,
    @MappingTarget Supplier supplier
  );
}
