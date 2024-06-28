package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import java.util.List;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CategoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CategoryResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

public interface ICategoryService extends 
    CreateService<CategoryRequest, CategoryResponse>,
    UpdateService<CategoryRequest, CategoryResponse, String>,
    DeleteService<String>{
    List<CategoryResponse> readAll();
}
