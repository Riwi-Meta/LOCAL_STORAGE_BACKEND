package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseForAdmin;
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
}
  