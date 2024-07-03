package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestUpdate {
    private String name;
    private String description;
}
