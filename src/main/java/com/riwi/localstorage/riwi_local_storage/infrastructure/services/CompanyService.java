package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CompanyRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CompanyResponseRelations;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Company;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.CompanyRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.CompanyMapper;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    public CompanyResponseRelations createCompany(CompanyRequest companyRequest) {
        Company company = companyMapper.toCompany(companyRequest);
        company = companyRepository.save(company);
        return companyMapper.toCompanyResponse(company);
    }

    public CompanyResponseRelations updateCompany(String id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        companyMapper.updateFromCompanyRequest(companyRequest, company);
        company = companyRepository.save(company);
        return companyMapper.toCompanyResponse(company);
    }

    public CompanyResponseRelations getCompanyById(String id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        return companyMapper.toCompanyResponse(company);
    }

    public List<CompanyResponseRelations> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toCompanyResponse)
                .collect(Collectors.toList());
    }

    public void deleteCompany(String id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        company.setIsEnable(false);
        companyRepository.save(company);
    }
}
