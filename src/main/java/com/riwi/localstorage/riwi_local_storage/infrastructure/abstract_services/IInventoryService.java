package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.InventoryRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventoryResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

@Service
public interface IInventoryService extends
 
    CreateService<InventoryRequest,InventoryResponse>,
    ReadAllService<InventoryResponse>,
    ReadService<InventoryResponse,String>,
    UpdateService<InventoryRequestUpdate,InventoryResponse, String> {
    
}
