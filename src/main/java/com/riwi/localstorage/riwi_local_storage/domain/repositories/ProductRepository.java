package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.BestSellingResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

    Page<Product> findAllByIsEnableTrue(Pageable pageable);
    Optional<Product> findByIdAndIsEnableTrue(String id);

    @Query("SELECT p FROM Product p WHERE p.isEnable = true " +
    "AND (COALESCE(:category, '') = '' OR p.category.name = :category)")
    Page<Product> findByCriteria(String category, PageRequest pageable);

    // @Query("SELECT p " +
    //        "FROM Product p " +
    //        "JOIN Inventory inv ON p.id = inv.product.id " +
    //        "JOIN SaleDetail sd ON inv.id = sd.inventory.id " +
    //        "JOIN Sale s ON sd.sale.id = s.id " +
    //        "WHERE inv.branch.id = :branchId " +
    //        "ORDER BY s.date DESC")
           @Query(value = "SELECT p.* " +
           "FROM product p " +
           "JOIN inventories inv ON p.id = inv.product_id " +
           "JOIN sale_detail sd ON inv.id = sd.inventory_id " +
           "JOIN sale s ON sd.sale_id = s.id " +
           "WHERE inv.branch_id = :branchId " +
           "ORDER BY s.date DESC", nativeQuery = true)
    List<Product> findRecentlySoldProducts(String branchId);

    @Query(value = "SELECT p.id, p.name, p.description, p.barcode, p.selling_price as sellingPrice, p.category_id as categoryId, SUM(sd.quantity) AS totalQuantity " +
            "FROM product p " +
            "JOIN inventories i ON p.id = i.product_id " +
            "JOIN sale_detail sd ON i.id = sd.inventory_id " +
            "JOIN sale s ON sd.sale_id = s.id " +
            "WHERE p.is_enable = true " +
            "AND s.date >= CURRENT_DATE - INTERVAL 3000 DAY " +
            "AND i.branch_id = :branchId " +
            "GROUP BY p.id, p.name, p.description, p.barcode, p.selling_price, p.category_id " +
            "ORDER BY totalQuantity DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Object[]> findBestSellingProductsByBranch(String branchId);
}
