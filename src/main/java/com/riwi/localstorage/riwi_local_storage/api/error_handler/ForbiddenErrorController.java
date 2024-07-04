package com.riwi.localstorage.riwi_local_storage.api.error_handler;

import com.riwi.localstorage.riwi_local_storage.api.dto.errors.ErrorResponse;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ForbiddenErrorController {

    @ExceptionHandler(ForbiddenException.class)
    public ErrorResponse accessDeniedException(ForbiddenException exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setStatus(HttpStatus.FORBIDDEN.name());
        errorResponse.setCode(HttpStatus.FORBIDDEN.value());

        return errorResponse;
    }
}
