package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreUpdateDisableRequest {

    @NotNull(message = "Status is required")
    private StatusType status;

}
