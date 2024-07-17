package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.ProductUpdateLocationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.query.Param;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.ProductRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BestSellingResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BranchResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseForAdmin;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.ProductResponseToBranch;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;


@Mapper(componentModel = "spring", uses = BranchMapper.class)
public interface ProductMapper {

    BranchMapper branchMapper = Mappers.getMapper(BranchMapper.class);
    
    
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


    void productToUpdateLocation(ProductUpdateLocationRequest request, @MappingTarget Product product);
    
    @Mapping(target = "name", expression = "java(mapBranchName(product))")
    @Mapping(target = "branch", expression = "java(mapBranch(product))")
    @Mapping(target = "quantity", expression = "java(mapQuantity(product))")
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

    default String mapBranchName(Product product) {
        if (product != null && product.getInventory() != null &&
            product.getInventory().get(0).getBranch().getName() != null ) {
            return product.getInventory().get(0).getBranch().getName();
        }
        return null; 
    }

    default BranchResponse mapBranch(Product product) {
        if (product != null && product.getInventory() != null &&
            !product.getInventory().isEmpty() &&
            product.getInventory().get(0).getBranch() != null) {
            return ProductMapper.branchMapper.branchToBranchResponse(product.getInventory().get(0).getBranch());
        }
        return null; 
    }

    default Double mapQuantity(Product product) {
        if (product != null && product.getInventory() != null &&
            product.getInventory().get(0).getQuantity() != null)
            {
            return product.getInventory().get(0).getQuantity();
        }
        return null; 
    }
}
