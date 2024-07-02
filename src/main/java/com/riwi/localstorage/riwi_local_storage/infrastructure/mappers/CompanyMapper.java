package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CompanyRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CompanyResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Company;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.CompanyRepository;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "isEnable", source = "isEnable")
    })
    public abstract Company toCompany(CompanyRequest companyRequest);

    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "isEnable", source = "isEnable")
    })
    public abstract CompanyResponse toCompanyResponse(Company company);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "isEnable", source = "isEnable")
    })
    public abstract void updateFromCompanyRequest(CompanyRequest companyRequest, @MappingTarget Company company);

    protected Company map(String companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }
}
