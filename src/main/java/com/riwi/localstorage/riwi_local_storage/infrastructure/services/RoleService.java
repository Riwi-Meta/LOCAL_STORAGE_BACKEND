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
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.RoleMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.RoleUpdateMapper;
import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.RoleAlreadyInactiveException;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.RoleNameAlreadyExistsException;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.RoleNotFoundException;

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
    private final RoleMapper roleMapper;

    /*----------------------------
    * GET ALL
    * ----------------------------
    */

    @Override
    public Page<RoleResponse> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(role -> this.roleMapper.toResponse(role));
    }

    /*------------------------------
     * GET BY ID
     * -----------------------------
     */
    @Override
    public Optional<RoleResponse> getById(String id) {
        return Optional.ofNullable(this.updateMapper.toResponse(this.find(id))); 
    }
    /*--------------------
     * CREATE ROLE
     * -------------------
     */

    @Override
    public RoleResponse create(RoleRequest request) {

        String newName = request.getName();

        Optional<Role> existingRoleName = this.repository.findByName(newName);

        if (existingRoleName.isPresent()) {
            throw new RoleNameAlreadyExistsException("Role with name " + newName + " already exists.");
        } else {

            Role role = this.createMapper.toEntity(request);

            return this.createMapper.toResponse(this.repository.save(role));
        }
    }

    /*----------------------
     * DISABLE ROLE (SOFT DELETE)
     * ---------------------
     */

    @Override
    public void delete(String id) { 
        Role roleDisable = this.find(id);
        if (roleDisable.getStatus() == StatusType.INACTIVE) {
            throw new RoleAlreadyInactiveException("Role with ID " + id + " is already inactive.");
        }
        roleDisable.setStatus(StatusType.INACTIVE);

        this.repository.save(roleDisable);
    }

    /*----------------------
     * UPDATE ROLE
     * ---------------------
     */

    @Override
    public RoleResponse update(String id, RoleRequestUpdate request) {
        String updatedName = request.getName();

        Optional<Role> existingRoleName = this.repository.findByName(updatedName);

        // Validation that the name is unique
        if (existingRoleName.isPresent()) {
            throw new RoleNameAlreadyExistsException("Role with name " + updatedName + " already exists.");
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
        return this.repository.findById(id).orElseThrow(()->new RoleNotFoundException("Role not found by Id:" + id));
    }
}
