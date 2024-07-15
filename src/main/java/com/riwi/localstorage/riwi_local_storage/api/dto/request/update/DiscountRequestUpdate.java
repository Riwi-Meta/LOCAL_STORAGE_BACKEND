package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import java.time.LocalDate;

import com.riwi.localstorage.riwi_local_storage.util.enums.DiscountType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountRequestUpdate {

    @NotNull
    private String id;
    
    @NotNull
    private DiscountType type;

    @NotNull
    @Min(0)
    private Double amount;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private Boolean isActive;

    @NotBlank
    private String code;
}
