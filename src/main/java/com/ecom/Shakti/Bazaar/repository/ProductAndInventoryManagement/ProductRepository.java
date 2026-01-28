package com.ecom.Shakti.Bazaar.repository.ProductAndInventoryManagement;

import com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement.Product;
import com.ecom.Shakti.Bazaar.Enum.ProductAndInventoryManagement.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find products by status (AVAILABLE, OUT_OF_STOCK, IN_REVIEW)
    List<Product> findByStatus(ProductStatus status);

    // Find products by category id
    List<Product> findByCategory_CategoryId(Long categoryId);

    // Find products by SHG id
    List<Product> findByShg_ShgId(Long shgId);

    // Search products by name (case-insensitive)
    List<Product> findByProductNameContainingIgnoreCase(String productName);
}
