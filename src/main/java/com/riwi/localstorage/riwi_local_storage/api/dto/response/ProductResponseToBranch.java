package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseToBranch {

    private String name;

    private String description;

    private String barcode;

    private Double sellingPrice;

    private Double quantity;

    private BranchResponse branch;
    
}
