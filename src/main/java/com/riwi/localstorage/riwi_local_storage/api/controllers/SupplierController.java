package com.riwi.localstorage.riwi_local_storage.api.controllers;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.SupplierRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponseRelations;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ISupplierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")
@AllArgsConstructor
public class SupplierController {

  @Autowired
  private ISupplierService supplierService;

  @PostMapping
  public ResponseEntity<SupplierResponseRelations> create(
    @Validated @RequestBody SupplierRequest request
  ) {
    return ResponseEntity.ok(supplierService.create(request));
  }

  @GetMapping
  public ResponseEntity<Page<SupplierResponseRelations>> getAll(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "5") int size
  ) {
    Pageable pageable = PageRequest.of(page, size);
    if (page != 0) pageable = PageRequest.of(page - 1, size);

    return ResponseEntity.ok(supplierService.getAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<SupplierResponseRelations> getById(String id) {
    SupplierResponseRelations response = supplierService
      .getById(id)
      .orElse(null);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/by-name/{name}")
  public ResponseEntity<SupplierResponseRelations> getByName(String name) {
    SupplierResponseRelations response = supplierService
      .getByName(name)
      .orElse(null);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(String id) {
    supplierService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/sendEmail")
  public ResponseEntity<Void> sendEmail(
    String supplierId,
    String title,
    String description,
    String name
  ) {
    supplierService.sendEmail(supplierId, title, description, name);
    return ResponseEntity.noContent().build();
  }
}
