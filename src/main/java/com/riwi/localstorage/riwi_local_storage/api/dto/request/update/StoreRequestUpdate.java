package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequestUpdate {

    @NotBlank(message = "The name is required")
    @Length(max = 100, message = "The name must be less than 100 characters")
    private String name;
    
}
