package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.StoreRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.StoreRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.StoreResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;


@Service
public interface IStoreService extends 
    CreateService<StoreRequest,StoreResponse>,
    DeleteService<String>,                                //this is disable status
    ReadAllService<StoreResponse>,
    ReadService<StoreResponse,Integer>,
    UpdateService<StoreRequestUpdate,StoreResponse, Integer> {
    
}
