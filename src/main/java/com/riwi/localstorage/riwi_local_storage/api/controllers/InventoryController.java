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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.InventoryRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IInventoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
    summary = "This method allows get all the inventaries in paginated form.", 
    description = "Retrieve a paginated list of all inventaries", 
    parameters = {
        @Parameter(name = "page", 
                   description = "Page number", 
                   schema = @Schema(
                    type = "integer", 
                    defaultValue = "1")),
        @Parameter(name = "size", 
                   description = "Page size", 
                   schema = @Schema(
                    type = "integer", 
                    defaultValue = "10"))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

     @GetMapping
     public ResponseEntity<Page<InventoryResponse>> getAll(@PageableDefault(page = 1, size = 10
     ) Pageable pageable){
        return ResponseEntity.ok(service.getAll(pageable));
     }

    /*--------------------
    * GET BY ID
    * -------------------
    */
    @Operation(summary = "This method allows get an inventary by an specific ID.", description = "Retrieves a inventary by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
     @GetMapping(path = "/{id}")
     public ResponseEntity<Optional<InventoryResponse>> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
     }

    /*--------------------
     * CREATE INVENTARY
     * -------------------
     */
    @Operation(summary = "This method allows create a new inventary.", description = "create a new inventary by entering the required data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<InventoryResponse> create(
            @Validated @RequestBody InventoryRequest request) {
        return ResponseEntity.ok(this.service.create(request));
    }

    /*----------------------
     * UPDATE INVENTORY
     * ---------------------
     */

    @PutMapping(path = "/{id}")
    public ResponseEntity<InventoryResponse> update(
        @Validated @RequestBody InventoryRequestUpdate request,
        @PathVariable String id
    ){
        return ResponseEntity.ok(this.service.update(id, request));
    }

    /*----------------------
     * DELETE INVENTORY (DISABLE ROLE - SOFT DELETE)
     * ---------------------
     */

    // insert here your code

}
