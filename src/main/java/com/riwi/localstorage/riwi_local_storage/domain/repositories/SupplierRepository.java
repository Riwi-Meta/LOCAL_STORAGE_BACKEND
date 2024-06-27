package com.riwi.localstorage.riwi_local_storage.domain.repositories;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
    Optional<Supplier> findByName(String name);
}
