package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CrudAbstractSevice <RQ, RS, String>{
  RS getById(String id);

  RS create(RQ request);

  RS update(String id, RQ request);
  
  void delete(String id);

  Page<RS> getAll(int page, int size);
}
