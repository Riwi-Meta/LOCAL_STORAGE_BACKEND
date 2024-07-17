package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventaryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.InventaryRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventaryResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

@Service
public interface IInventaryService extends
 
CreateService<InventaryRequest,InventaryResponse>,
    DeleteService<String>,                                //this is disable status
    ReadAllService<InventaryResponse>,
    ReadService<InventaryResponse,String>,
    UpdateService<InventaryRequestUpdate,InventaryResponse, String>{
    
}
