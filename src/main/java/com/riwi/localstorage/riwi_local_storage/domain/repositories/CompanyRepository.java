package com.riwi.localstorage.riwi_local_storage.domain.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Optional<Company> findByName(String name);
}
