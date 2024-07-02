package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{    
    List<Category> findAllByIsEnableTrue();
    Optional<Category> findByIdAndIsEnableTrue(String id);
}
