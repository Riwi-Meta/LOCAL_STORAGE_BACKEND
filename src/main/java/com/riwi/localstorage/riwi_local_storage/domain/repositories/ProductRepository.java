package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

    Page<Product> findAllByIsEnableTrue(Pageable pageable);
    Optional<Product> findByIdAndIsEnableTrue(String id);
}
