package com.riwi.localstorage.riwi_local_storage.util.exeptions;

public class ForbiddenException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Access Denied: You are not allowed to access this";

    public ForbiddenException() {
        super(ERROR_MESSAGE);
    }
}

