package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

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
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryDisableMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryUpdateMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventaryService implements IInventaryService {
    
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
    public InventaryResponse create(InventaryRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<InventaryResponse> getAll(Pageable pageable) {
        return this.repository.findAll(pageable).map(inventory -> this.inventoryMapper.toResponse(inventory));
    }

    @Override
    public Optional<InventaryResponse> getById(String id) {
        return Optional.of(this.inventoryMapper.toResponse(this.find(id)));
    }

    @Override
    public InventaryResponse update(String id, InventaryRequestUpdate request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    private Inventory find(String id){
        return this.repository.findById(id).orElseThrow(()->new IdNotFoundException("Inventary", id));
    }
    
}
