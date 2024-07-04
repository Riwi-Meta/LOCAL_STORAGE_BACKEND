package com.riwi.localstorage.riwi_local_storage.api.dto.errors;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class ErrorResponse extends BaseErrorResponse{
    private String message;  
}
