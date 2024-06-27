package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import java.time.LocalDate;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CashRegisterRequest {

    
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
