package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String name;

    private String description;

    private String barcode;

    private Double sellingPrice;
}
