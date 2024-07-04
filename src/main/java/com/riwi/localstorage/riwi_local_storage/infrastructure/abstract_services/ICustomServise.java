package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CustomRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CustomResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

public interface ICustomServise extends CreateService<CustomRequest, CustomResponse>,
        UpdateService<CustomRequest, CustomResponse, String>,
        ReadAllService<CustomResponse>
        {



}
