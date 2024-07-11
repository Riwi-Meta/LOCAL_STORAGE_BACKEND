package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {
  Page<Discount> findAllByIsActive(boolean isActive, Pageable pageable);
}
