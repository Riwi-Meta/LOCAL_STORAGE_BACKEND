package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.ProductUpdateLocationRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.*;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Branch;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Inventory;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.BranchRepository;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.InventoryRepository;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
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

    private final BranchRepository branchRepository;

    private final InventoryRepository inventoryRepository;
    
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


    public ProductResponseToBranch getAllAndBranchByStoreId(String id, String storeId){

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

    public List<BestSellingResponse> findBestSellingProductsByBranch(String branchId) {
        List<Object[]> request = this.productRepository.findBestSellingProductsByBranch(branchId);
        List<BestSellingResponse> response = new ArrayList<>(request.size());
        for (Object[] row : request) {
            BestSellingResponse bestSellingResponse = new BestSellingResponse();
            bestSellingResponse.setId(row[0].toString());
            bestSellingResponse.setName(row[1].toString());
            bestSellingResponse.setDescription(row[2].toString());
            bestSellingResponse.setBarcode(row[3].toString());
            bestSellingResponse.setSellingPrice((Double) row[4]);
            bestSellingResponse.setCategoryId(row[5].toString());
            bestSellingResponse.setTotalQuantity((Double) row[6]);
            
            response.add(bestSellingResponse);
        }
        return  response;
    }

    @Override
    public ProductResponseToBranch productUpdateLocation(
            String id, String branchId, String inventoryId, ProductUpdateLocationRequest request) {


        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow();

       Branch branch = branchRepository.findById(branchId).orElseThrow();

        inventory.setBranch(branch);

        this.inventoryRepository.save(inventory);

        Product product = find(id);

        return productMapper.mapProduct(product, inventory);
    }

}
