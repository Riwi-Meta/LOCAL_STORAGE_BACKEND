package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import java.util.Date;
import java.util.List;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;
import com.riwi.localstorage.riwi_local_storage.domain.entities.SaleDetail;
import com.riwi.localstorage.riwi_local_storage.domain.entities.SupplierOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {
    
    
    private String id;
    private Product product;
    private Double quantity;
    private Date lastUpdateDate;
    private Date expirationDate;
    private List<SaleDetail> saleDetails;

    private List<SupplierOrder> supplierOrders;
    
}
