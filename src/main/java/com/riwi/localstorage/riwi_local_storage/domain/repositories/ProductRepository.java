package com.riwi.localstorage.riwi_local_storage.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
    //        "JOIN Inventory inv ON p.inventory.id = inv.id " +
    //        "JOIN SaleDetail sd ON inv.id = sd.inventory.id " +
    //        "JOIN Sale s ON sd.sale.id = s.id " +
    //        "WHERE inv.branch.id = :branchId " +
    //        "ORDER BY s.date DESC")
    @Query(value = 
    "SELECT p.* " +
    "FROM product p " +
    "JOIN inventories inv ON p.inventory_id = inv.id " +
    "JOIN sale_detail sd ON inv.id = sd.inventory_id " +
    "JOIN sale s ON sd.sale_id = s.id " +
    "WHERE inv.branch_id = :branchId " +
    "ORDER BY s.date DESC",
    nativeQuery = true)
    List<Product> findRecentlySoldProducts(String branchId);
}
