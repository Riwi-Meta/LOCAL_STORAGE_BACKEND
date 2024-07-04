package com.riwi.localstorage.riwi_local_storage.api.dto.errors;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListErrorsResponse extends BaseErrorResponse {
    
    private List<String> errors;
    
}