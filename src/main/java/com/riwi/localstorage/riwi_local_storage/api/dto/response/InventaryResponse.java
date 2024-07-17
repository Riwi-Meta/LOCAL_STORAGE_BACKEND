package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import java.util.Date;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Store;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventaryResponse {
    
    
    private String id;
    private Store storeId;
    private Product productId;
    private Double quantity;
    private Date lastUpdateDate;
    private Supplier supplierOrderId;
    private Date expirationDate;
    //private Branch branchId;
    
}
