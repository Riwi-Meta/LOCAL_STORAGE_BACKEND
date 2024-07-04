package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CategoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CategoryResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

import java.util.List;

public interface ICategoryService extends 
    CreateService<CategoryRequest, CategoryResponse>,
    UpdateService<CategoryRequest, CategoryResponse, String>,
    DeleteService<String>{
    List<CategoryResponse> readAll();
}
