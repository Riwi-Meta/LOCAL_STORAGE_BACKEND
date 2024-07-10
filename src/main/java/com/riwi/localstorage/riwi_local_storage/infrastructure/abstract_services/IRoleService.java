package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.RoleRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.RoleRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RoleResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

@Service
public interface IRoleService extends 
    CreateService<RoleRequest,RoleResponse>,
    DeleteService<String>,                                //this is disable status
    ReadAllService<RoleResponse>,
    ReadService<RoleResponse,String>,
    UpdateService<RoleRequestUpdate,RoleResponse, String> {
    
}
