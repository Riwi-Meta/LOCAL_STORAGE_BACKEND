package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseToBranch;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RecentSaleResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.ProductRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IProductService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.ProductMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.RecentSaleMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ProductService implements IProductService{
    
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final RecentSaleMapper recentSaleMapper;
    
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
    public Page<ProductResponse> findByCriteria(String category, PageRequest pageable) {
        return productRepository.findByCriteria(category, pageable).map(productMapper::productToProductResponse);
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

    @Override
    public List<RecentSaleResponse> findRecentlySoldProducts(String branch_id) {
                List<Product> products = productRepository.findRecentlySoldProducts(branch_id);
                System.out.println(products);
        return products.stream()
                .map(recentSaleMapper::toRecentSaleResponse)
                .collect(Collectors.toList());
    }
}
