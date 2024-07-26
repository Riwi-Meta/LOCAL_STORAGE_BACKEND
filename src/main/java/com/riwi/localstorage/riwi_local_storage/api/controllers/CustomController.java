package com.riwi.localstorage.riwi_local_storage.api.controllers;


import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CustomRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CustomResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ICustomServise;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/custom")
@AllArgsConstructor
public class CustomController {


    private final ICustomServise customServise;


    @PostMapping
    public ResponseEntity<CustomResponse> create(
            @Validated @RequestBody CustomRequest request) {

        return ResponseEntity.ok(this.customServise.create(request));
    }


    @GetMapping
    public ResponseEntity<Page<CustomResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(this.customServise.getAll(pageable));
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<CustomResponse> update(
            @Validated @RequestBody CustomRequest request,
            @PathVariable String id) {
        return ResponseEntity.ok(this.customServise.update(id, request));
    }


}
