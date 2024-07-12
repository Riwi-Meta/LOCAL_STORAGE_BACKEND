package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "stores")
@AllArgsConstructor
public class StoreController {

    /*----------------------
     * GET ALL ROLES
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

     //insert here your code

    /*--------------------
     * CREATE ROLE
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

     //insert here your code

    /*----------------------
     * UPDATE ROLE
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

     //insert here your code

    /*----------------------
     * DELETE ROLE (DISABLE ROLE - SOFT DELETE)
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
    
}
