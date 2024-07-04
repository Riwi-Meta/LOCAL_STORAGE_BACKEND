package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.BranchRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BranchResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

public interface IBranchService extends
        CreateService<BranchRequest, BranchResponse>,
        ReadService<BranchResponse, String>,
        UpdateService<BranchRequest, BranchResponse, String>,
        DeleteService<String>

{ }