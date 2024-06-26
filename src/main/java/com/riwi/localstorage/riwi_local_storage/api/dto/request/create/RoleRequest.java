package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
    private String name; 
    private String description;
    private StatusType status;
}
