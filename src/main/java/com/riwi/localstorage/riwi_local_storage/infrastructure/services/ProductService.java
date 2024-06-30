package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.ProductRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IProductService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.ProductMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{
    
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    
    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.productRequestToProduct(request);
        
        return productMapper.productToProductResponse(this.productRepository.save(product));
    }

    @Override
    public Optional<ProductResponse> getById(String id) {
        
        return productRepository.findById(id)
                .map(productMapper::productToProductResponse);
    }

    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ProductResponse update(String id, ProductRequest request) {
        Product product = find(id);
        productMapper.productToUpdate(request, product);

        return productMapper.productToProductResponse(this.productRepository.save(product));
    }

    @Override
    public void delete(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("No product"));

        productRepository.deleteById(product.getId());
    }
    
    public Product find(String Id){
        return this.productRepository.findById(Id).orElseThrow(() -> new RuntimeException("No product"));
    }
}
