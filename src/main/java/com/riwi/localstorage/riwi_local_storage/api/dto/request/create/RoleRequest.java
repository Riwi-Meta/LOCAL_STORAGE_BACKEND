package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {

    @Schema(description = "Name  of the role", example = "admin") 
    @NotBlank(message = "the name of the role is required") 
    @Size(max = 50, message = "The RoleName must have a maximum of 50 characters") 
    private String name; 
    
    @Schema(description = "Description  of the role", example = "with this ADMIN user you can add or modify inventories, manage products, among others.") 
    @NotBlank(message = "the name of the role is required") 
    @Size(max = 50, message = "The Description must have a maximum of 500 characters") 
    private String description;
    
    @Schema(description = "Status of the role", example = "Default status is ACTIVE") 
    @NotBlank(message = "Status is required.") 
    private StatusType status;
}
