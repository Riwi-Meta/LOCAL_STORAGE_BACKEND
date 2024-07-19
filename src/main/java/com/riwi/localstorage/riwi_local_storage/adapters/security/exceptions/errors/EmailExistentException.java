package com.riwi.localstorage.riwi_local_storage.adapters.security.exceptions.errors;

public class EmailExistentException extends RuntimeException{
    public EmailExistentException(){
        super("This email is already used.");
    }
}
