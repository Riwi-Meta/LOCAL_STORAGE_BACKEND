package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.RecentSaleResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;
import com.riwi.localstorage.riwi_local_storage.domain.entities.SaleDetail;

@Mapper(componentModel = "spring")
public interface RecentSaleMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "quantity", expression = "java(mapQuantity(product))")
    @Mapping(target = "date", expression = "java(mapDate(product))")
    @Mapping(target = "unitPrice", expression = "java(mapUnitPrice(product))")
    @Mapping(target = "totalPrice", expression = "java(mapTotal(product))")
    RecentSaleResponse toRecentSaleResponse(Product product);

    default Double mapQuantity(Product product) {
        if (product != null && product.getInventory() != null &&
            product.getInventory().getSaleDetails() != null &&
            !product.getInventory().getSaleDetails().isEmpty()) {
            return product.getInventory().getSaleDetails().get(0).getQuantity();
        }
        return null; // or handle appropriately if data is not available
    }

    default Date mapDate(Product product) {
        if (product != null && product.getInventory() != null &&
            product.getInventory().getSaleDetails() != null &&
            !product.getInventory().getSaleDetails().isEmpty()) {
            SaleDetail firstSaleDetail = product.getInventory().getSaleDetails().get(0);
            if (firstSaleDetail.getSale() != null) {
                return firstSaleDetail.getSale().getDate();
            }
        }
        return null; // or handle appropriately if data is not available
    }

    default Double mapUnitPrice(Product product) {
        if (product != null && product.getInventory() != null &&
            product.getInventory().getSaleDetails() != null &&
            !product.getInventory().getSaleDetails().isEmpty()) {
            return product.getInventory().getSaleDetails().get(0).getUnitPrice();
        }
        return null; // or handle appropriately if data is not available
    }

    default Double mapTotal(Product product) {
        if (product != null && product.getInventory() != null &&
            product.getInventory().getSaleDetails() != null &&
            !product.getInventory().getSaleDetails().isEmpty()) {
            return product.getInventory().getSaleDetails().get(0).getTotal();
        }
        return null; // or handle appropriately if data is not available
    }
}