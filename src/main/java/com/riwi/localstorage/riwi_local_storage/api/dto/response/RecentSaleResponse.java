package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecentSaleResponse {
        private String name;
        private Double quantity;
        private Date date;
        private Double unitPrice;
        private Double totalPrice;
}
