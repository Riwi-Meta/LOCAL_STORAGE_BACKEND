package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.riwi.localstorage.riwi_local_storage.api.dto.errors.ErrorsResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.errors.ErrorResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.MembershipRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.MembershipEnabledRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IMembershipService;
import com.riwi.localstorage.riwi_local_storage.util.enums.MembershipSortCriteria;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/memberships")
public class MembershipController {

  @Autowired
  private final IMembershipService imembershipService;

  @Operation(summary = "Create membership")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
  })
  @PostMapping(path = "/add")
  public ResponseEntity<MembershipResponse> create(@Validated @RequestBody MembershipRequest request) {
    System.out.println(request);
    return ResponseEntity.ok(this.imembershipService.create(request));
  }

  @Operation(summary = "this method allows get all the list of memberships in paginated form")
    @ApiResponse(responseCode = "400", description = "When the connection with the data base fail", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))})
  @GetMapping
  public ResponseEntity<Page<MembershipResponse>> getAll(
      @RequestParam(required = false) MembershipSortCriteria sortCriteria,
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size) {

    if (page < 1) {
      page = 1;
    }
    if (sortCriteria == null) {
      sortCriteria = MembershipSortCriteria.NAME_ASC;
    }
    Sort sort = Sort.by(sortCriteria.getDirection(), sortCriteria.getField());

    Pageable pageable = PageRequest.of(page - 1, size, sort);

    return ResponseEntity.ok(this.imembershipService.getAll(pageable));
  }

  @Operation(summary = "This method allows you modify the status of the a membership for a id specific")
    @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
  @DeleteMapping("/{id}/status")
  public ResponseEntity<Void> updateMembershipStatus(@PathVariable String id,
      @Validated @RequestBody MembershipEnabledRequest membershipEnabledRequest) {

    imembershipService.updateMembershipStatus(id, membershipEnabledRequest.isEnabled());

    return ResponseEntity.ok().build();
  }

  @Operation(summary = "This method allows you find a membership for a id specific")
    @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
  @GetMapping("/{id}")
  public ResponseEntity<MembershipResponse> get(@PathVariable String id) {
    return ResponseEntity.ok(this.imembershipService.getById(id));
  }

  @Operation(summary = "This method allows you modify a membership for a id specific")
    @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
  @PutMapping("/{id}")
  public ResponseEntity<MembershipResponse> updateMMembership(
      @PathVariable String id,
      @Validated @RequestBody MembershipRequest membershipRequest) {
    return ResponseEntity.ok(imembershipService.update(id, membershipRequest));
  }
}
