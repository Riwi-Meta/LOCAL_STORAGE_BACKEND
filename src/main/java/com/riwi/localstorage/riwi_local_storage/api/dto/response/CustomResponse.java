package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse {
    
    private String id;

    private int minimumStock;

    private Store store;
}
