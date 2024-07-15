package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.repository.query.Param;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BestSellingResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseForAdmin;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseToBranch;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enable", ignore = true)
    @Mapping(target = "inventory", ignore = true)
    @Mapping(target = "category.id", source = "categoryId")
    Product productRequestToProduct(ProductRequest request);

    ProductResponse productToProductResponse(Product product);

    @Mapping(target = "categoryName", source = "category.name")
    ProductResponseForAdmin productToProductResponseForAdmin(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enable", ignore = true)
    @Mapping(target = "inventory", ignore = true)
    @Mapping(target = "category.id", source = "categoryId")
    void productToUpdate(ProductRequest request, @MappingTarget Product product);

    // @Mapping(source = "product.inventory.branch.id", target = "branch.id")
    // @Mapping(source = "product.inventory.branch.city", target = "branch.city")
    // @Mapping(source = "product.inventory.branch.email", target = "branch.email")
    // @Mapping(source = "product.inventory.branch.phone", target = "branch.phone")
    ProductResponseToBranch productToProductResponseToBranch(Product product);
    
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "sellingPrice", source = "sellingPrice")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "barcode", source = "barcode")
    @Mapping(target = "categoryId", source = "categoryId")
    @Mapping(target = "totalQuantity", source = "totalQuantity")
    BestSellingResponse objectToBestSellingResponse(
        @Param("id") String id,
        @Param("name") String name,
        @Param("sellingPrice") Double sellingPrice,
        @Param("description") String description,
        @Param("barcode") String barcode,
        @Param("categoryId") String categoryId,
        @Param("totalQuantity") Double totalQuantity
    );
}
  