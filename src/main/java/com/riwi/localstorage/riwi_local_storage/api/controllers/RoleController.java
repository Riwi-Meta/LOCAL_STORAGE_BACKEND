package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.RoleRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RoleResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.services.RoleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "roles")
@AllArgsConstructor
public class RoleController {
    @Autowired
    private final RoleService service;

    @PutMapping(path = "/{id}")
    public ResponseEntity<RoleResponse> update(
            @PathVariable String id,
            @Validated @RequestBody RoleRequestUpdate request) {
        return ResponseEntity.ok(this.service.update(id, request));
    }
}