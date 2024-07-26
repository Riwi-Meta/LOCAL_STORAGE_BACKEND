package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import com.riwi.localstorage.riwi_local_storage.util.enums.DiscountType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountResponse {

  private String id;
  private DiscountType type;
  private double amount;
  private LocalDate startDate;
  private LocalDate endDate;
  private Boolean isActive;
  private String code;
}
