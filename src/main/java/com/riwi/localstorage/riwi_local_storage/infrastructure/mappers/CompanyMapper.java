package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CompanyRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CompanyResponseRelations;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Company;

@Mapper(componentModel = "spring", uses = SupplierMapper.class)
public interface CompanyMapper {

  @Mappings({
      @Mapping(target = "id", ignore = true),
  })
  Company toCompany(CompanyRequest companyRequest);

  CompanyResponseRelations toCompanyResponse(Company company);

  @Mappings({
    @Mapping(target = "id", ignore = true),
})
  void updateFromCompanyRequest(CompanyRequest companyRequest, @MappingTarget Company company);
}
