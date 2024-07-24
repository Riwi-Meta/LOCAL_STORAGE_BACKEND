package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Custom;

public interface CustomRespository extends JpaRepository<Custom, String> {

}
