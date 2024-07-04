package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{
    
}
