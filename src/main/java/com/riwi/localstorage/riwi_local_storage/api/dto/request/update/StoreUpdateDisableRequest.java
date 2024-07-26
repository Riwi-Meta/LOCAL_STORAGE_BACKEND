package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreUpdateDisableRequest {

    @Schema(description = "Store status", example = "INACTIVE")
    @NotNull(message = "Status is required")
    private StatusType status;

}
