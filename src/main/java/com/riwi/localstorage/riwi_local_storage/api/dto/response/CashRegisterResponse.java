package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CashRegisterResponse {

    private String id;
    private LocalDate date;
    private Double totalAmount;
    private String note;
    private Double finishAmount;
    private Double initAmount;
    
}
