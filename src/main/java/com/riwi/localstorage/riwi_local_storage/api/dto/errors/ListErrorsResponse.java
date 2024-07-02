package com.riwi.localstorage.riwi_local_storage.api.dto.errors;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListErrorsResponse extends BaseErrorResponse {
    
    private List<String> errors;
    
}