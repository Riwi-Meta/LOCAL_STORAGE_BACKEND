package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CashRegisterRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CashRegisterResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.CashRegister;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.CashRegisterRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ICashRegisterService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.CashRegisterMapper;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CashRegisterService implements ICashRegisterService {

  @Autowired
  private CashRegisterRepository cashRegisterRepository;

  @Autowired
  private CashRegisterMapper cashRegisterMapper;

  @Override
  public CashRegisterResponse getById(String id) {

    return cashRegisterMapper.cashRegisterToCashRegisterResponsesponse(this.find(id));
  }

  @Override
  public CashRegisterResponse create(CashRegisterRequest request) {
    CashRegister cashRegister = cashRegisterMapper.cashRegisterRequestToCashRegister(request);

    return cashRegisterMapper.cashRegisterToCashRegisterResponsesponse(this.cashRegisterRepository.save(cashRegister));
  }

  @Override
  public CashRegisterResponse update(String id, CashRegisterRequest request) {
    CashRegister cashRegister = this.find(id);
    cashRegister = cashRegisterMapper.cashRegisterRequestToCashRegister(request);
    cashRegister.setId(id);
    return cashRegisterMapper.cashRegisterToCashRegisterResponsesponse(this.cashRegisterRepository.save(cashRegister));
  }

  @Override
  public void delete(String id) {
    this.cashRegisterRepository.delete(this.find(id));
  }

  @Override
  public Page<CashRegisterResponse> getAll(int page, int size) {
    if (page < 0)
      page = 0;

    PageRequest pagination = PageRequest.of(page, size);

    this.cashRegisterRepository.findAll(pagination);

    return this.cashRegisterRepository.findAll(pagination)
        .map(cashRegisterMapper::cashRegisterToCashRegisterResponsesponse);

  }

  private CashRegister find(String id) {
    // this method is incomplete, missing idNotFoud
    return this.cashRegisterRepository.findById(id).orElseThrow();
  }

}
