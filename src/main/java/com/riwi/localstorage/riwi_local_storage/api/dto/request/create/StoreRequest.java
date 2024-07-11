package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import org.hibernate.validator.constraints.Length;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

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

    @NotBlank(message = "The name is required")
    @Length(message = "The name must be less than 100 characters", max = 100 )
    private String name;

    @NotBlank(message = "The User_id is required")
    private String user_id;

    @NotNull(message = "Status is required.") 
    private StatusType status;
    
}
