
package com.ecom.Shakti.Bazaar.service.ProductAndInventoryManagement;

import com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement.Product;

import java.util.List;

public interface ProductService {

    // Create Product
    Product saveProduct(Product product);

    // Get Product by ID
    Product getProductById(Long productId);

    // Get All Products
    List<Product> getAllProducts();

    // Update Product
    Product updateProduct(Long productId, Product product);

    // Delete Product
    void deleteProduct(Long productId);
}
