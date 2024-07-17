package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import java.util.Date;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Branch;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventaryRequest {


    @NotBlank(message = "the id of the product is required") 
    private Product product;

    @NotBlank(message = "the quantity of the product is required") 
    private Double quantity;

    @NotBlank(message = "the last update date of the product is required") 
    private Date lastUpdateDate;

    @NotBlank(message = "the expiration date of the product is required") 
    private Date expirationDate;

    @NotBlank(message = "the id of the branch is required") 
    private Branch branch;

}
