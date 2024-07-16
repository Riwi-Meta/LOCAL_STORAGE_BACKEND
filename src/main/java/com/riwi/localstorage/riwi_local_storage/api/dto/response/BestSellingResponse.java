package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BestSellingResponse {

    private String id;

    private String name;

    private String description;

    private String barcode;

    private Double sellingPrice;

    private String categoryId;

    private Double totalQuantity;
}
