package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.Optional;

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

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductController {
    
    private final IProductService productService;

    @GetMapping(path = "/admin/{id}")
    public ResponseEntity<Optional<ProductResponse>> get(@PathVariable String id){
        return ResponseEntity.ok(this.productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable){
        Page<ProductResponse> products = this.productService.getAll(pageable);

        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Validated @RequestBody ProductRequest request){
        return ResponseEntity.ok(this.productService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> update(@Validated @RequestBody ProductRequest request, @PathVariable String id){
        return ResponseEntity.ok(this.productService.update(id, request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable String id){
        return ResponseEntity.noContent().build();
    }
}
