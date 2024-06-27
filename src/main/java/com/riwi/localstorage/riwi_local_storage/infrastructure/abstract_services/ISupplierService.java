package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import java.time.LocalDateTime;
import java.util.Optional;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.SupplierRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponseRelations;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;

public interface ISupplierService extends
      CreateService<SupplierRequest, SupplierResponseRelations>,
      ReadService<SupplierResponseRelations, String>,DeleteService<String>,
      ReadAllService<SupplierResponseRelations> {

   void sendEmail(String supplierId, String title, String description, String name, LocalDateTime date);

   Optional<SupplierResponseRelations> getByName(String supplierName);

}
