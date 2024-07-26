package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import com.riwi.localstorage.riwi_local_storage.util.enums.DiscountType;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRequestUpdate {

    private Boolean isActive;

    private DiscountType type;

    @Positive(message = "The amount must be greater than 0")
    private double amount;

    @FutureOrPresent(message = "The date cant be in the past")
    private LocalDate startDate;

    @Future(message = "The end date cant be in the past")
    private LocalDate endDate;

    @NotBlank(message = "The code cant be empty")
    private String code;
}
