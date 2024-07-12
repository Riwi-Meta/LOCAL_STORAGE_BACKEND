package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{
    Optional<Store> findByName(String name);
}
