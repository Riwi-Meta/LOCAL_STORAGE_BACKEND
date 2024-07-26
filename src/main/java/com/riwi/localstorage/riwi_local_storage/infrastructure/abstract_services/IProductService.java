package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import java.util.List;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.ProductUpdateLocationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BestSellingResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseToBranch;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RecentSaleResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

public interface IProductService extends 
                CreateService<ProductRequest, ProductResponse>, 
                ReadService<ProductResponse, String>,
                UpdateService<ProductRequest, ProductResponse, String>, 
                DeleteService<String>{      
                    
            Page<ProductResponse> findByCriteria(String category, PageRequest pageable);
            List<RecentSaleResponse> findRecentlySoldProducts(String branchId);
            List<BestSellingResponse> findBestSellingProductsByBranch(String branchId);

            ProductResponseToBranch getAllAndBranchByStoreId(String id, String storeId);

            ProductResponseToBranch productUpdateLocation(String id, String storeId, String inventoryId, ProductUpdateLocationRequest request);

}