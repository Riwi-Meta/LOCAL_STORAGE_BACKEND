package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.SupplierRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponseRelations;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Company;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Supplier;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.CompanyRepository;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.SupplierRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ISupplierService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.helpers.EmailHelpper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.SupplierMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SuplierService implements ISupplierService {

  @Autowired
  private final SupplierRepository supplierRepository;

  @Autowired
  private final SupplierMapper supplierMapper;

  @Autowired
  private final EmailHelpper emailHelpper;

  private CompanyRepository companyRepository;

  @Override
  public SupplierResponseRelations create(SupplierRequest request) {
    Supplier supplier = supplierMapper.toSupplier(request);

    Company company = companyRepository
      .findById(request.getCompanyId())
      .orElseThrow(() ->
        new IdNotFoundException("COMPANY", request.getCompanyId())
      );

    supplier.setCompany(company);

    supplier.setIsEnable(true);
    return supplierMapper.toSupplierResponse(supplierRepository.save(supplier));
  }

  @Override
  public Optional<SupplierResponseRelations> getById(String id) {
    Optional<Supplier> supplier = supplierRepository.findById(id);
    if (supplier.isEmpty()) throw new IdNotFoundException("SUPPLIER", id);

    return supplier.map(supplierMapper::toSupplierResponse);
  }

  @Override
  public Page<SupplierResponseRelations> getAll(Pageable pageable) {
    return supplierRepository
      .findAll(pageable)
      .map(supplier -> supplierMapper.toSupplierResponse(supplier));
  }

  @Override
  public void sendEmail(
    String supplierId,
    String title,
    String description,
    String name
  ) {
    Supplier supplier = supplierRepository.findById(supplierId).orElseThrow();
    emailHelpper.sendEmail(
      supplier.getEmail(),
      description,
      title,
      name,
      LocalDateTime.now(),
      "src/main/resources/static/emails/supplier_email.html"
    );
  }

  @Override
  public void delete(String id) {
    Supplier supplier = supplierRepository
      .findById(id)
      .orElseThrow(() -> new IdNotFoundException("SUPPLIER", id));
    supplier.setIsEnable(false);
    supplierRepository.save(supplier);
  }

  @Override
  public Optional<SupplierResponseRelations> getByName(String supplierName) {
    Optional<Supplier> supplier = supplierRepository.findByName(supplierName);
    if (supplier.isEmpty()) throw new IdNotFoundException(
      "SUPPLIER",
      supplierName
    );
    return supplier.map(supplierMapper::toSupplierResponse);
  }
}