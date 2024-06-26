package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.localstorage.riwi_local_storage.domain.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
