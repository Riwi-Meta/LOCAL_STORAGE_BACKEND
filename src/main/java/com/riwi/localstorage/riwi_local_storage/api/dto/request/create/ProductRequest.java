package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String description;

    @NotBlank(message = "Barcode is required")
    private String barcode;

    @NotNull(message = "Selling price is required")
    private Double sellingPrice;

    private Double buyingPrice;

    private String categoryId;
}
