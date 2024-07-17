package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Date;
import java.util.Optional;

import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.InventoryRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventoryResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Inventory;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.InventoryRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryCreateMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryDisableMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryUpdateMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.InventoryExpirationDatePassed;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryService implements IInventoryService {
    
    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private InventoryCreateMapper createMapper;

    @Autowired
    private InventoryUpdateMapper updateMapper;
    
    @Autowired
    private InventoryDisableMapper disableMapper;
    
    @Autowired
    private InventoryRepository repository;

    @Override
    public InventoryResponse create(InventoryRequest request) {
        Date today = new Date();

        if (request.getExpirationDate().before(today)) {
            throw new InventoryExpirationDatePassed("The expiration date of the item in the inventory have passed");
        } else {
            Inventory inventory = this.createMapper.toEntity(request);

            return this.createMapper.toResponse(inventory);
        }
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<InventoryResponse> getAll(Pageable pageable) {
        return this.repository.findAll(pageable).map(inventory -> this.inventoryMapper.toResponse(inventory));
    }

    @Override
    public Optional<InventoryResponse> getById(String id) {
        return Optional.ofNullable(this.inventoryMapper.toResponse(this.find(id)));
    }

    @Override
    public InventoryResponse update(String id, InventoryRequestUpdate request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    private Inventory find(String id){
        return this.repository.findById(id).orElseThrow(()->new IdNotFoundException("Inventory", id));
    }

}
