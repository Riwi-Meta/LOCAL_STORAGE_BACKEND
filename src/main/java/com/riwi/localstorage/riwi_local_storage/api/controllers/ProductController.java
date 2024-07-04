package com.riwi.localstorage.riwi_local_storage.api.controllers;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BranchResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseToBranch;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping(path = "/admin/{id}")
    public ResponseEntity<Optional<ProductResponse>> get(@PathVariable String id) {
        return ResponseEntity.ok(this.productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page - 1, size);

        Page<ProductResponse> products = this.productService.getAll(pagination);

        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Validated @RequestBody ProductRequest request) {
        return ResponseEntity.ok(this.productService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> update(@Validated @RequestBody ProductRequest request, @PathVariable String id) {
        return ResponseEntity.ok(this.productService.update(id, request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/findAll/{id}")
    public ProductResponseToBranch getAllAndBranch(@PathVariable String id) {
        return Optional.of(this.productService.find(id))
                .map(product -> {
                    ProductResponseToBranch productResponseToBranch = new ProductResponseToBranch();
                    productResponseToBranch.setBarcode(product.getBarcode());
                    productResponseToBranch.setName(product.getName());
                    productResponseToBranch.setDescription(product.getDescription());
                    productResponseToBranch.setSellingPrice(product.getSellingPrice());
                    BranchResponse branchResponse = new BranchResponse();
                    branchResponse.setId(product.getInventory().getBranch().getId());
                    branchResponse.setCity(product.getInventory().getBranch().getCity());
                    branchResponse.setEmail(product.getInventory().getBranch().getEmail());
                    branchResponse.setPhone(product.getInventory().getBranch().getPhone());
                    productResponseToBranch.setBranch(branchResponse);
                    return productResponseToBranch;
                }).orElse(new ProductResponseToBranch());
    }


}
