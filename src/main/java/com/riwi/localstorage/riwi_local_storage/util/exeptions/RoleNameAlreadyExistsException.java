package com.riwi.localstorage.riwi_local_storage.util.exeptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RoleNameAlreadyExistsException extends RuntimeException {

    public RoleNameAlreadyExistsException(String message) {
        super(message);
    }


}
