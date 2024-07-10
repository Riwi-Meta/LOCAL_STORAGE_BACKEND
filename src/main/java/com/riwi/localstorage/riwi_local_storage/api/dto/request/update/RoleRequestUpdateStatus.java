package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestUpdateStatus {
    private StatusType status;
}
