package com.riwi.localstorage.riwi_local_storage.api.dto.errors;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class ErrorResponse extends BaseErrorResponse{
    private String message;  
}
