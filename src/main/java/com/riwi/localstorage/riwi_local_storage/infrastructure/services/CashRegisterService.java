package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CashRegisterRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CashRegisterResponse;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.CashRegisterRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ICashRegisterService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CashRegisterService implements ICashRegisterService {

  @Autowired
  private CashRegisterRepository cashRegisterRepository;

  @Override
  public CashRegisterResponse getById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public CashRegisterResponse create(CashRegisterRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public CashRegisterResponse update(String id, CashRegisterRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public Page<CashRegisterResponse> getAll(int page, int size) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

}
