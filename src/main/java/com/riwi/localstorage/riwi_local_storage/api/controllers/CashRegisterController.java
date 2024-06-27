package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CashRegisterRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CashRegisterResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ICashRegisterService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/cash_register")
@AllArgsConstructor
public class CashRegisterController {

    private final ICashRegisterService cashRegisterService;

    @GetMapping
    public ResponseEntity<Page<CashRegisterResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(this.cashRegisterService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity <Optional<CashRegisterResponse>> getCashResgirterById(@PathVariable String id) {
        return ResponseEntity.ok(this.cashRegisterService.getById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CashRegisterResponse> update(
            @Validated @RequestBody CashRegisterRequest request,
            @PathVariable String id) {
        return ResponseEntity.ok(this.cashRegisterService.update(id, request));
    }

    
}
