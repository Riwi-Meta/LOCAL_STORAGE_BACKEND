package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import com.riwi.localstorage.riwi_local_storage.util.enums.DiscountType;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class DiscountRequest {

  @NotNull(message = "The type is required")
  private DiscountType type;
  @NotNull(message = "The amount is required")
  @Positive(message = "The amount must be greater than 0")
  private double amount;
  @NotNull(message = "The start date is required")
  @FutureOrPresent(message = "The date cant be in the past")
  private LocalDate startDate;
  @NotNull(message = "The end Date is required")
  @Future(message = "The end date cant be in the past")
  private LocalDate endDate;
  @NotEmpty(message = "The code is required")
  private String code;
}
