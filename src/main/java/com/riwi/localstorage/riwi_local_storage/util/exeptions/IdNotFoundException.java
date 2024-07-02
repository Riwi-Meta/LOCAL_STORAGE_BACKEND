package com.riwi.localstorage.riwi_local_storage.util.exeptions;

public class IdNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "No records found in the entity [%s] with the specified id %s.";

    public IdNotFoundException(String entityName, Long id) {
        super(String.format(ERROR_MESSAGE, entityName,id));
    }

    public IdNotFoundException(String entityName, String id) {
        super(String.format(ERROR_MESSAGE, entityName,id));
    }

    public IdNotFoundException(String entityName, Integer id) {
        super(String.format(ERROR_MESSAGE, entityName,id));
    }

}
