package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.CashRegister;

@Repository
public interface CashRegisterRepository extends JpaRepository<CashRegister, String>{
  
}
