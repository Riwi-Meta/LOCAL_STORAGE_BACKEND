package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestUpdate {
    
    
    @NotNull(message = "the quantity of the product is required") 
    private Double quantity;
    
    @NotNull(message = "the last update date of the product is required") 
    private Date lastUpdateDate;
    
    @NotNull(message = "the expiration date of the product is required") 
    private Date expirationDate;
    
    @NotBlank(message = "the id of the product is required") 
    private String productId;
    
    @NotBlank(message = "the id of the supplier is required") 
    private String supplierOrderId;
    
    @NotBlank(message = "the id of the store is required") 
    private String storeId;

    @NotBlank(message = "the id of the branch is required") 
    private String branchId;
}
