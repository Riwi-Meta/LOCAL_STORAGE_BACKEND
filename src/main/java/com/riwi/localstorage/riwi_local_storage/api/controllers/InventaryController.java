package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

     @GetMapping
     public ResponseEntity<Page<InventaryResponse>> getAll(@PageableDefault(page = 0, size = 10, sort = "status") Pageable pageable){
        return ResponseEntity.ok(service.getAll(pageable));
     }

     /*--------------------
     * GET BY ID
     * -------------------
     */

     @GetMapping(path = "/{id}")
     public ResponseEntity<Optional<InventaryResponse>> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
     }

    /*--------------------
     * CREATE INVENTARY
     * -------------------
     */

     //insert here your code

    /*----------------------
     * UPDATE INVENTARY
     * ---------------------
     */

     //insert here your code

    /*----------------------
     * DELETE INVENTARY (DISABLE ROLE - SOFT DELETE)
     * ---------------------
     */

     //insert here your code
    
}
