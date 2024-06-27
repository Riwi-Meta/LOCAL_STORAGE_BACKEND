package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CashRegisterResponse {

    private String id;
    private LocalDate date;
    private Double totalAmount;
    private String note;
    private Double finishAmount;
    private Double initAmount;
    
}
