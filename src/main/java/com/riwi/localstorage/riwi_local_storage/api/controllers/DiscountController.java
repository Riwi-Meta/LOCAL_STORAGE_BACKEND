package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.errors.ErrorResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.errors.ErrorsResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.DiscountRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.EntityEnabledRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.DiscountResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IDiscountService;
import com.riwi.localstorage.riwi_local_storage.util.enums.DiscountSortCriteria;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/discounts")
@AllArgsConstructor
public class DiscountController {

  @Autowired
  private final IDiscountService iDiscountService;

  @Operation(summary = "this method allows get all the list of the in paginated form")
  @ApiResponse(responseCode = "400", description = "When the operation is successful", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class)) })
  @GetMapping
  public ResponseEntity<Page<DiscountResponse>> getAll(
      @RequestParam(required = false) DiscountSortCriteria sortCriteria,
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size) {

    if (page < 1) {
      page = 1;
    }
    if (sortCriteria == null) {
      sortCriteria = DiscountSortCriteria.START_DATE_ASC;
    }
    Sort sort = Sort.by(sortCriteria.getDirection(), sortCriteria.getField());

    Pageable pageable = PageRequest.of(page - 1, size, sort);

    if (sortCriteria.getIsActiveFilter() != null) {
      return ResponseEntity.ok(this.iDiscountService.findAllByIsActive(sortCriteria.getIsActiveFilter(), pageable));
    }

    return ResponseEntity.ok(this.iDiscountService.getAll(pageable));
  }

  @Operation(summary = "This method allows you to find a discount with an specific id")
  @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<Optional<DiscountResponse>> getDiscount(@PathVariable String id) {
    return ResponseEntity.ok(this.iDiscountService.getById(id));
  }

  @Operation(summary = "Update an existing discount")
  @ApiResponse(responseCode = "404", description = "Discount not found", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @ApiResponse(responseCode = "400", description = "Invalid data", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<DiscountResponse> updateDiscount(@PathVariable String id, @Valid @RequestBody DiscountRequestUpdate request) {
    return ResponseEntity.ok(this.iDiscountService.update(id, request));
  }


  @Operation(summary = "This method allows you to 'delete' a discount for a id specific")
  @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @DeleteMapping("/{id}/status")
  public ResponseEntity<Void> updateDiscountStatus(@PathVariable String id,
      @Validated @RequestBody EntityEnabledRequest discountEnabledRequest) {

    iDiscountService.updateDiscountStatus(id, discountEnabledRequest.isEnabled());

    return ResponseEntity.ok().build();
  }

}
