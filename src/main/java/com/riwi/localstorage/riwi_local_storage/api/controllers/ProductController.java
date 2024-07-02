package com.riwi.localstorage.riwi_local_storage.api.controllers;

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

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseForAdmin;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductController {
    
    private final IProductService productService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponseForAdmin> read(@PathVariable String id){
        return ResponseEntity.ok(this.productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Validated @RequestBody ProductRequest request){
        return ResponseEntity.ok(this.productService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> update(@Validated @RequestBody ProductRequest request, @PathVariable String id){
        return ResponseEntity.ok(this.productService.update(id, request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
