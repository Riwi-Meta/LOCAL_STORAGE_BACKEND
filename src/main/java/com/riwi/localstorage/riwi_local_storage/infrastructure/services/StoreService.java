package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.StoreRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.StoreRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.StoreResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Store;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.StoreRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IStoreService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.StoreMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.StoreNameAlreadyExistsException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class StoreService implements IStoreService {
    
    @Autowired
    private final StoreRepository storeRepository;

    @Autowired
    private final StoreMapper storeMapper;
    
    @Override
    public StoreResponse create(StoreRequest request) {
        String name = request.getName();
        Optional<Store> existingStoreName = this.storeRepository.findByName(name);
        if (existingStoreName.isPresent()) {
            throw new StoreNameAlreadyExistsException("Store with name "+name+" already exists");
        }else{
            Store store = this.storeMapper.toEntity(request);
            return this.storeMapper.toResponse(this.storeRepository.save(store));
        }
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<StoreResponse> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<StoreResponse> getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public StoreResponse update(String id, StoreRequestUpdate request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
