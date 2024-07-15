package com.riwi.localstorage.riwi_local_storage.util.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StoreNameAlreadyExistsException extends RuntimeException {

    public StoreNameAlreadyExistsException(String message){
        super(message);
    }
}
