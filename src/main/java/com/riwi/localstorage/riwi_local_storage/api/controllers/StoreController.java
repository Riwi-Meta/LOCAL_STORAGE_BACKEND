package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.StoreRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.StoreRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.StoreResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IStoreService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "stores")
@AllArgsConstructor
public class StoreController {

    @Autowired
    private final IStoreService service;

    /*----------------------
     * GET ALL STORE
     * ---------------------
     */
/*     @Operation(
    summary = "Get all Stores", 
    description = "Retrieve a paginated list of all Stores", 
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
                    defaultValue = "10")),
        @Parameter(name = "sort", 
                   description = "Sort criteria", 
                   array = @ArraySchema(
                    schema = @Schema(
                        type = "string", 
                        defaultValue = "status", 
                        allowableValues = {"id", "name", "user", "branches", "status"})))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    }) */   //UNCOMMENT THIS PART OF THE CODE WHEN YOU MAKE THE CONTROLLER

     //insert here your code
    @GetMapping
    public ResponseEntity<Page<StoreResponse>> getAll(
            @PageableDefault(page = 0, size = 10, sort = "status") Pageable pageable) {
        Page<StoreResponse> responses = this.service.getAll(pageable);
        return ResponseEntity.ok(responses);
    }

    /*--------------------
    * GET BY ID
    * -------------------
    */
/*     @Operation(summary = "Get Store by ID", description = "Retrieves a Store by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    }) */   //UNCOMMENT THIS PART OF THE CODE WHEN YOU MAKE THE CONTROLLER
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<StoreResponse>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    /*--------------------
     * CREATE STORE
     * -------------------
     */
/*     @Operation(summary = "creates a new Store", description = "create a new Stotr by entering the required data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    }) */   //UNCOMMENT THIS PART OF THE CODE WHEN YOU MAKE THE CONTROLLER

    @PostMapping
    public ResponseEntity<StoreResponse> create(
            @Validated @RequestBody StoreRequest request) {
        return ResponseEntity.ok(this.service.create(request));
    }

    /*----------------------
     * UPDATE STORE
     * ---------------------
     */
/*     @Operation(summary = "update  Role by ID", description = "updates a previously created role and the ID and the new modified parameters must be sent through the Path, value cannot be less than 1")
     @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    }) */   //UNCOMMENT THIS PART OF THE CODE WHEN YOU MAKE THE CONTROLLER

        @PutMapping(path = "/{id}")
        public ResponseEntity<StoreResponse> update(
            @PathVariable Integer id,
            @Validated @RequestBody StoreRequestUpdate request
        ){
            return ResponseEntity.ok(this.service.update(id, request));
        }


    /*----------------------
     * DELETE STORE (DISABLE STORE - SOFT DELETE)
     * ---------------------
     */

    /*      @Operation(summary = "Disable Store by ID", description = "Disables a previously created Store identified by its ID")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "OK"),
                @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
                @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
                @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
                @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
        }) */   //UNCOMMENT THIS PART OF THE CODE WHEN YOU MAKE THE CONTROLLER
        
     //insert here your code
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        this.service.delete(id);
        
        return ResponseEntity.noContent().build();
    }
}
