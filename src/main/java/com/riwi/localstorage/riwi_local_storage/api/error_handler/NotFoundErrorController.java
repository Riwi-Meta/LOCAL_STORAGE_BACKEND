package com.riwi.localstorage.riwi_local_storage.api.error_handler;

import com.riwi.localstorage.riwi_local_storage.api.dto.errors.ErrorResponse;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundErrorController {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse NotFoundException(ResourceNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.name());
        errorResponse.setCode(HttpStatus.NOT_FOUND.value());

        return errorResponse;
    }



}
