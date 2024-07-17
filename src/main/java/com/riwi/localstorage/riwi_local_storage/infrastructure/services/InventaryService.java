package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventaryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.InventaryRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventaryResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Inventory;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.InventoryRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IInventaryService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryCreateMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.InventoryExpirationDatePassed;



import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventaryService implements IInventaryService {
    @Autowired
    private final InventoryRepository repository;

    @Autowired
    private final InventoryCreateMapper createMapper;

    /*--------------------
     * CREATE INVENTORY
     * -------------------
     */

    @Override
    public InventaryResponse create(InventaryRequest request) {
        Date today = new Date();

        if (request.getExpirationDate().before(today)) {
            throw new InventoryExpirationDatePassed("The expiration date of the item in the inventory have passed");
        } else {
            Inventory inventory = this.createMapper.toEntity(request);

            return this.createMapper.toResponse(this.repository.save(inventory));
        }
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<InventaryResponse> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<InventaryResponse> getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public InventaryResponse update(String id, InventaryRequestUpdate request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
