package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import java.time.LocalDateTime;
import java.util.Optional;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CompanyRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CompanyResponseRelations;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;

public interface ICompanyService extends
      CreateService<CompanyRequest, CompanyResponseRelations>,
      ReadService<CompanyResponseRelations, String>,DeleteService<String>,
      ReadAllService<CompanyResponseRelations> {

   void sendEmail(String companyId, String title, String description, String name, LocalDateTime date);

   Optional<CompanyResponseRelations> getByName(String companyName);

}
