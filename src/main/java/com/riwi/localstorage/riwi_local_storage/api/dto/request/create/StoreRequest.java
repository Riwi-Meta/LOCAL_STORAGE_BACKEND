package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import org.hibernate.validator.constraints.Length;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequest {

    @Schema(description = "Store Name", example = "Tienda ABC")
    @NotBlank(message = "The name is required")
    @Length(message = "The name must be less than 100 characters", max = 100 )
    private String name;

    @Schema(description = "User Id", example = "550e8400-e29b-41d4-a716-446655440000")
    @NotBlank(message = "The User_id is required")
    private String user_id;

    @Schema(description = "Store status", example = "ACTIVE")
    @NotNull(message = "Status is required.") 
    private StatusType status;
    
}
