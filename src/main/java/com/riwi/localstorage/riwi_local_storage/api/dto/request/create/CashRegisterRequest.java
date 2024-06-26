package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import java.time.LocalDate;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CashRegisterRequest {

    @NotNull(message = "ID cannot be null")
    @NotBlank(message = "ID cannot be blank")
    private String id;

    @NotNull(message = "Date cannot be null")
    private LocalDate date;

    @NotNull(message = "Total amount cannot be null")
    @Min(value = 0, message = "Total amount must be greater than or equal to 0")
    private Double totalAmount;

    private String note;

    @NotNull(message = "Finish amount cannot be null")
    @Min(value = 0, message = "Finish amount must be greater than or equal to 0")
    private Double finishAmount;

    @NotNull(message = "Initial amount cannot be null")
    @Min(value = 0, message = "Initial amount must be greater than or equal to 0")
    private Double initAmount;
    
}
