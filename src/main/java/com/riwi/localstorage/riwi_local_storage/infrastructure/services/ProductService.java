package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseToBranch;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.ProductRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IProductService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.ProductMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ProductService implements IProductService{
    
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    
    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.productRequestToProduct(request);
        product.setEnable(true);
        return productMapper.productToProductResponse(this.productRepository.save(product));
    }

    @Override
    public Optional<ProductResponse> getById(String id) {
        
        return productRepository.findById(id)
                .map(productMapper::productToProductResponse);
    }

    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        return productRepository.findAllByIsEnableTrue(pageable)
        .map(productMapper::productToProductResponse);
    }

    @Override
    public ProductResponse update(String id, ProductRequest request) {
        Product product = find(id);
        productMapper.productToUpdate(request, product);
 
        return productMapper.productToProductResponse(this.productRepository.save(product));
    }

    @Override
    public void delete(String id) {
        Product product = this.find(id);
        if (product != null) {
            product.setEnable(false);
            this.productRepository.save(product);
        }
    }
    
    public Product find(String id) {
        return productRepository.findByIdAndIsEnableTrue(id).orElseThrow(() -> new IdNotFoundException("Product", id));
    }

    public ProductResponseToBranch getAllAndBranch(String id) {
        return productRepository.findByIdAndIsEnableTrue(id)
                .map(productMapper::productToProductResponseToBranch)
                .orElse(new ProductResponseToBranch());
    }

}
