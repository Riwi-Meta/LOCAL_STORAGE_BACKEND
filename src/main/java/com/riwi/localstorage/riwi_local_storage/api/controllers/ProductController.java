package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.List;
import java.util.Optional;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.ProductUpdateLocationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BestSellingResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseToBranch;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RecentSaleResponse;
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
    public ResponseEntity<Page<ProductResponse>> getAll(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(defaultValue = "") String category
    ){
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page -1, size);

        Page<ProductResponse> products = this.productService.findByCriteria(category ,pagination);

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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(path = "/findAll/{storeId}/{id}")
    public ResponseEntity<ProductResponseToBranch> getAllAndBranchByStoreId(
            @PathVariable String id,
            @PathVariable String storeId) {
        return ResponseEntity.ok(this.productService.getAllAndBranchByStoreId(id, storeId));
    }

    @GetMapping(path = "/recentSoldProducts/{branch_id}")
    public ResponseEntity<List<RecentSaleResponse>> findRecentlySoldProducts(@PathVariable String branch_id) {
        return ResponseEntity.ok(this.productService.findRecentlySoldProducts(branch_id));
    }

    @GetMapping(path = "/bestSelling/{branch_id}")
    public ResponseEntity<List<BestSellingResponse>> findBestSellingProductsByBranch(@PathVariable String branch_id) {
        return ResponseEntity.ok(this.productService.findBestSellingProductsByBranch(branch_id));
    }

    @PutMapping(path = "/{id}/{branchId}")
    public ResponseEntity<ProductResponseToBranch> updateLocation(
            @Validated @RequestBody ProductUpdateLocationRequest request,
            @PathVariable String id,
            @PathVariable String branchId) {
        return ResponseEntity.ok(this.productService.productUpdateLocation(id, branchId, request));
    }

}
