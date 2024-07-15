package com.riwi.localstorage.riwi_local_storage.util.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StoreAlreadyInactiveException extends RuntimeException {
    public StoreAlreadyInactiveException(String message) {
        super(message);
    }
}