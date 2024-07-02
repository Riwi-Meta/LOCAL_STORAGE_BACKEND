package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {}
