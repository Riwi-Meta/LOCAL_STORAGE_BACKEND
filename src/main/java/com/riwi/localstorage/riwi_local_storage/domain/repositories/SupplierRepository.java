package com.riwi.localstorage.riwi_local_storage.domain.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
    Page<Supplier> findAllByName(String name);
}
