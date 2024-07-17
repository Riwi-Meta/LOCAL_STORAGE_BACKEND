package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import java.util.Date;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Branch;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Store;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Supplier;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventaryRequest {

    @Schema(description = "Id of the store owns the inventory",example = "Juanita store") 
    @NotBlank(message = "the id of the store is required") 
    private Store storeId;

    @NotBlank(message = "the id of the product is required") 
    private Product productId;

    @NotBlank(message = "the quantity of the product is required") 
    private Double quantity;

    @NotBlank(message = "the last update date of the product is required") 
    private Date lastUpdateDate;

    @NotBlank(message = "the id of the supplier is required") 
    private Supplier supplierOrderId;

    @NotBlank(message = "the expiration date of the product is required") 
    private Date expirationDate;

    @NotBlank(message = "the id of the branch is required") 
    private Branch branchId;

}
