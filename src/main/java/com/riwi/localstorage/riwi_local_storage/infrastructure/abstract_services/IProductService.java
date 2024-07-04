package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.*;

public interface IProductService extends 
                CreateService<ProductRequest, ProductResponse>, 
                ReadService<ProductResponse, String>, 
                ReadAllService<ProductResponse>, 
                UpdateService<ProductRequest, ProductResponse, String>, 
                DeleteService<String>{

    Product find(String id);
}
