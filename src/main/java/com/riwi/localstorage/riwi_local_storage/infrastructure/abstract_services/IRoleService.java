package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.RoleRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RoleResponse;

public interface IRoleService  extends CRUDService<RoleRequest, RoleResponse, Long>  {
    
}
