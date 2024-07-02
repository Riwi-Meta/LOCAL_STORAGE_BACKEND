package com.riwi.localstorage.riwi_local_storage.util.exeptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE_TEMPLATE = "Resource can not be found: %s.";

    public ResourceNotFoundException(String resourceName) {
        super(String.format(ERROR_MESSAGE_TEMPLATE, resourceName));
    }
}

