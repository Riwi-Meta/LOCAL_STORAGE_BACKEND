package com.riwi.localstorage.riwi_local_storage.seeder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Role;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.RoleRepository;
import com.riwi.localstorage.riwi_local_storage.util.enums.RoleType;
import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class DatabaseSeed implements CommandLineRunner {
    @Autowired
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
       log.info("Seeding database Role Executed"); 

       if (this.roleRepository.count() > 0) return;
       
       Role admin = new Role();
       Role user = new Role();

       admin.setName(RoleType.ADMIN.toString());
       admin.setDescription(RoleType.ADMIN.getDescription());
       admin.setStatus(StatusType.ACTIVE);

       user.setName(RoleType.USER.toString());
       user.setDescription(RoleType.USER.getDescription());
       user.setStatus(StatusType.ACTIVE);

       roleRepository.save(admin);
       roleRepository.save(user);

    }
    
}