package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import java.util.UUID;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CashRegisterRequest;

public interface ICashRegisterService extends CrudAbstractSevice<CashRegisterRequest, CashRegisterResponse, String> {
  
}
