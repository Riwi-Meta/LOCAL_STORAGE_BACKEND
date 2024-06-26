package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestUpdate {
    private String name;
    private String description;
}
