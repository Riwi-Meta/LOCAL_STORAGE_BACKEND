package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.RoleRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.RoleRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RoleResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Role;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.RoleRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IRoleService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.RoleCreateMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.RoleDisableMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.RoleMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.RoleUpdateMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {
    @Autowired
    private final RoleRepository repository;

    @Autowired
    private final RoleCreateMapper createMapper;

    @Autowired
    private final RoleUpdateMapper updateMapper;

    @Autowired
    private final RoleDisableMapper disableMapper;

    @Autowired
    private final RoleMapper roleMapper;

    @Override
    public RoleResponse create(RoleRequest request) {

        String newName = request.getName();

        Optional<Role> existingRoleName = this.repository.findByName(newName);

        if(existingRoleName.isPresent()){
            return null;
        }else{

            Role role = this.createMapper.toEntity(request);
    
            return this.createMapper.toResponse(this.repository.save(role));
        }
    }

    @Override
    public void delete(String id) {    //DISABLE STATUS
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<RoleResponse> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(role->this.roleMapper.toResponse(role));
    }

    @Override
    public Optional<RoleResponse> getById(String id) {
        return Optional.ofNullable(this.updateMapper.toResponse(this.find(id))); //???
    }

    @Override
    public RoleResponse update(String id, RoleRequestUpdate request) {
        String updatedName = request.getName();

        Optional<Role> existingRoleName = this.repository.findByName(updatedName);
        
        // Validation that the name is unique
        if (existingRoleName.isPresent()) {
            return null; // Here you have to set the error message when configuring the errors
        } else {
            Role role = this.find(id);
        
            Role roleUpdate = this.updateMapper.toEntity(request);

            roleUpdate.setId(id);
            roleUpdate.setStatus(role.getStatus());
            roleUpdate.setUsers(role.getUsers());
            
            return this.updateMapper.toResponse(this.repository.save(roleUpdate));
        }
    }

    private Role find(String id) {
        return this.repository.findById(id).orElseThrow(null); // Here you have to set the error message when configuring the errors
    }
}
