package com.riwi.localstorage.riwi_local_storage.api.controllers;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CategoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CategoryResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = "/category")
@AllArgsConstructor
public class CategoryController {


    private final ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> read() {
        return ResponseEntity.ok(this.categoryService.readAll());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@Validated @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(this.categoryService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable String id ,@Validated @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(this.categoryService.update(id, request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable String id){
        return ResponseEntity.noContent().build();
    }
}
