package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  public CashRegisterResponse create(CashRegisterRequest request) {
    CashRegister cashRegister = cashRegisterMapper.cashRegisterRequestToCashRegister(request);

    return cashRegisterMapper.cashRegisterToCashRegisterResponse(this.cashRegisterRepository.save(cashRegister));
  }

  @Override
  public Page<CashRegisterResponse> getAll(Pageable pageable) {
    return cashRegisterRepository.findAll(pageable).map(cashRegisterMapper::cashRegisterToCashRegisterResponse);
}

  @Override
  public Optional<CashRegisterResponse> getById(String id) {
    Optional<CashRegister> cashRegisterOptional = cashRegisterRepository.findById(id);
    return cashRegisterOptional.map(cashRegisterMapper::cashRegisterToCashRegisterResponse);
  }

  @Override
  public CashRegisterResponse update(String id, CashRegisterRequest request) {
    CashRegister cashRegister = find(id)
        .orElseThrow(() -> new IllegalArgumentException("CashRegister not found with id: " + id));

    cashRegister = cashRegisterMapper.cashRegisterRequestToCashRegister(request);
    cashRegister.setId(id);
    CashRegister updatedCashRegister = cashRegisterRepository.save(cashRegister);
    return cashRegisterMapper.cashRegisterToCashRegisterResponse(updatedCashRegister);
  }

  private Optional<CashRegister> find(String id) {
    return cashRegisterRepository.findById(id);
  }
}
