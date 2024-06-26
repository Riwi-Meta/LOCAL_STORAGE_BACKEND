package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;



import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.SupplierRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadService;

public interface ISupplierService extends 
CreateService<SupplierRequest, SupplierResponse>,
ReadService<SupplierResponse, String>,
ReadAllService<SupplierResponse> {
    
   void sendEmail(String supplierId);
 
}
