package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

    Page<Product> findAllByIsEnableTrue(Pageable pageable);
    Optional<Product> findByIdAndIsEnableTrue(String id);

    @Query("SELECT p FROM Product p WHERE p.isEnable = true " +
    "AND (COALESCE(:category, '') = '' OR p.category.name = :category)")
    Page<Product> findByCriteria(String category, PageRequest pageable);
}
