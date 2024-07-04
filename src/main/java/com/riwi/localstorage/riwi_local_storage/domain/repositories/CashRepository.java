package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepository extends JpaRepository<Cash, String>{
    
}
