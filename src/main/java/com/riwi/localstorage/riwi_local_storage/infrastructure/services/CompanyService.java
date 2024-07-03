package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CompanyRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CompanyResponseRelations;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Company;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.CompanyRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ICompanyService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.CompanyMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

  @Autowired
  private final CompanyRepository companyRepository;

  @Autowired
  private final CompanyMapper companyMapper;

  @Override
  public CompanyResponseRelations create(CompanyRequest request) {
    Company company = companyMapper.toCompany(request);

    company.setIsEnable(true);
    company = companyRepository.save(company);
    return companyMapper.toCompanyResponse(company);
  }

  @Override
  public Optional<CompanyResponseRelations> getById(String id) {
    Optional<Company> company = companyRepository.findById(id);
    if (company.isEmpty()) throw new IdNotFoundException("company", id);

    return company.map(companyMapper::toCompanyResponse);
  }

  @Override
  public void delete(String id) {
    Company company = companyRepository
      .findById(id)
      .orElseThrow(() -> new IdNotFoundException("SUPPLIER", id));
    company.setIsEnable(false);
    companyRepository.save(company);
  }

  @Override
  public Page<CompanyResponseRelations> getAll(Pageable pageable) {
    return companyRepository
      .findAll(pageable)
      .map(supplier -> companyMapper.toCompanyResponse(supplier));
  }
}
