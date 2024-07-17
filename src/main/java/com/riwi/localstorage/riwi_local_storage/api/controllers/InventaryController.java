package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventaryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventaryResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IInventaryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "inventaries")
@AllArgsConstructor
public class InventaryController {
    @Autowired
    private final IInventaryService service;

    /*----------------------
     * GET ALL INVENTARIES
     * ---------------------
     */

    // insert here your code

    /*--------------------
    * GET BY ID
    * -------------------
    */

    // insert here your code

    /*--------------------
     * CREATE INVENTARY
     * -------------------
     */
    @PostMapping
    public ResponseEntity<InventaryResponse> create(
            @Validated @RequestBody InventaryRequest request) {
        return ResponseEntity.ok(this.service.create(request));
    }

    /*----------------------
     * UPDATE INVENTARY
     * ---------------------
     */

    // insert here your code

    /*----------------------
     * DELETE INVENTARY (DISABLE ROLE - SOFT DELETE)
     * ---------------------
     */

    // insert here your code

}
