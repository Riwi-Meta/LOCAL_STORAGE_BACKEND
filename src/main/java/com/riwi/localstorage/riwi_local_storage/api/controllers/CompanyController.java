package com.riwi.localstorage.riwi_local_storage.api.controllers;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CompanyRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CompanyResponseRelations;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ICompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

  @Autowired
  private final ICompanyService companyService;

  @PostMapping
  public ResponseEntity<CompanyResponseRelations> create(
    @Validated @RequestBody CompanyRequest request
  ) {
    return ResponseEntity.ok(companyService.create(request));
  }

  @GetMapping
  public ResponseEntity<Page<CompanyResponseRelations>> getAll(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "5") int size
  ) {
    Pageable pageable = PageRequest.of(page, size);
    if (page != 0) pageable = PageRequest.of(page - 1, size);

    return ResponseEntity.ok(companyService.getAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<CompanyResponseRelations> getById(String id) {
    CompanyResponseRelations response = companyService.getById(id).orElse(null);
    return ResponseEntity.ok(response);
  }

  // TESTE

  @GetMapping("/teste")
  public String EJEMPLO_OJO() {
    return "Esto es un ejemplo";
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(String id) {
    companyService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
