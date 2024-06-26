package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CrudAbstractSevice <RQ, RS, UUID>{
  RS getById(UUID id);

  RS create(RQ request);

  RS update(UUID id, RQ request);
  
  void delete(UUID id);

  Page<RS> getAll(int page, int size);
}
