package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    @Size(min = 5, max = 100, message = "The category name must have a maximum of 100 characters.")
    private String name;

    private String description;
}
