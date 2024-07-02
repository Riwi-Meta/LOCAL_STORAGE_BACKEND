package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CompanyRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CompanyResponseRelations;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = SupplierMapper.class)
public interface CompanyMapper {
  @Mappings(
    {
      @Mapping(target = "id", ignore = true),
      @Mapping(target = "isEnable", ignore = true),
      @Mapping(target = "suppliers", ignore = true),
    }
  )
  Company toCompany(CompanyRequest companyRequest);

  @Mapping(target = "suppliers", source = "suppliers")
  CompanyResponseRelations toCompanyResponse(Company company);

  @Mappings(
    {
      @Mapping(target = "id", ignore = true),
      @Mapping(target = "isEnable", ignore = true),
      @Mapping(target = "suppliers", ignore = true),
    }
  )
  void updateFromCompanyRequest(
    CompanyRequest companyRequest,
    @MappingTarget Company company
  );
}
