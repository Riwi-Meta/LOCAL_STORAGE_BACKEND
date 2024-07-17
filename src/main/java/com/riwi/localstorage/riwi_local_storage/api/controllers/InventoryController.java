package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.Optional;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventoryResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IInventoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "inventaries")
@AllArgsConstructor
public class InventoryController {
    @Autowired
    private final IInventoryService service;

    /*----------------------
     * GET ALL INVENTARIES
     * ---------------------
     */

     @GetMapping
     public ResponseEntity<Page<InventoryResponse>> getAll(@PageableDefault(page = 1, size = 10
     ) Pageable pageable){
        return ResponseEntity.ok(service.getAll(pageable));
     }

    /*--------------------
    * GET BY ID
    * -------------------
    */

     @GetMapping(path = "/{id}")
     public ResponseEntity<Optional<InventoryResponse>> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
     }

    /*--------------------
     * CREATE INVENTARY
     * -------------------
     */
    @PostMapping
    public ResponseEntity<InventoryResponse> create(
            @Validated @RequestBody InventoryRequest request) {
        return ResponseEntity.ok(this.service.create(request));
    }

    /*----------------------
     * UPDATE INVENTORY
     * ---------------------
     */

    // insert here your code

    /*----------------------
     * DELETE INVENTORY (DISABLE ROLE - SOFT DELETE)
     * ---------------------
     */

    // insert here your code

}
