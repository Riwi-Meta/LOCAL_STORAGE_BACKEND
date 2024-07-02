package com.riwi.localstorage.riwi_local_storage.api.error_handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.localstorage.riwi_local_storage.api.dto.errors.BaseErrorResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.errors.ListErrorsResponse;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleBadRequest(
            MethodArgumentNotValidException exception) {

        List<String> errors = new ArrayList<>();

        exception.getAllErrors()
                .forEach(error -> errors.add(error.getDefaultMessage()));

        ListErrorsResponse errorsResponse = new ListErrorsResponse();
        errorsResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorsResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        errorsResponse.setErrors(errors);
        return errorsResponse;
    }

}