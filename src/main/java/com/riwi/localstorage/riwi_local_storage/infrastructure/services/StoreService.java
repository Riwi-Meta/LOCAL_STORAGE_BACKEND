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
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.StoreUpdateMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.StoreNameAlreadyExistsException;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.StoreNotFoundException;

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

    @Autowired
    private final StoreUpdateMapper updateMapper;
    
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

    /*----------------------------
    * GET ALL
    * ----------------------------
    */

    @Override
    public Page<StoreResponse> getAll(Pageable pageable) {
        return storeRepository.findAll(pageable).map(store -> this.storeMapper.toResponse(store));
    }

    /*----------------------------
    * GET BY ID 
    * ----------------------------
    */

    @Override
    public Optional<StoreResponse> getById(Integer id) {
       return Optional.ofNullable(this.updateMapper.toResponse(this.find(id))); 
    }

    @Override
    public StoreResponse update(Integer id, StoreRequestUpdate request) {
        String updateStoreName = request.getName();

        Optional<Store> existingStoreName = this.storeRepository.findByName(updateStoreName);

        if (existingStoreName.isPresent()) {
            throw new StoreNameAlreadyExistsException("Store with name "+updateStoreName+ " already exists");
        }else{
            Store store = this.find(id);

            Store storeUpdate = this.updateMapper.toEntity(request);

            storeUpdate.setId(id);
            storeUpdate.setStatus(store.getStatus());
            storeUpdate.setUser(store.getUser());

            return this.updateMapper.toResponse(this.storeRepository.save(storeUpdate));
        }
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Store find(Integer id) {
        return this.storeRepository.findById(id).orElseThrow(()->new StoreNotFoundException("Store not found by Id:" + id));
    }

}

