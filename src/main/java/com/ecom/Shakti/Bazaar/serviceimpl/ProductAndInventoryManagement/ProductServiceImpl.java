
package com.ecom.Shakti.Bazaar.serviceimpl.ProductAndInventoryManagement;

import com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement.Product;
import com.ecom.Shakti.Bazaar.repository.ProductAndInventoryManagement.ProductRepository;
import com.ecom.Shakti.Bazaar.service.ProductAndInventoryManagement.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // Constructor Injection (BEST PRACTICE)
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.orElse(null);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Optional<Product> existingProduct = productRepository.findById(productId);

        if (existingProduct.isPresent()) {
            Product p = existingProduct.get();
            p.setProductName(product.getProductName());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setStock(product.getStock());
            p.setStatus(product.getStatus());
            p.setCategory(product.getCategory());
            p.setShg(product.getShg());
            p.setSop(product.getSop());
            p.setQualityCertificate(product.getQualityCertificate());
            p.setTraceability(product.getTraceability());

            return productRepository.save(p);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
