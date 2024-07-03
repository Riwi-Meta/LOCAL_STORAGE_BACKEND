package com.riwi.localstorage.riwi_local_storage.api.dto.errors;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseErrorResponse implements Serializable {
    private String status;
    private Integer code; 
}
